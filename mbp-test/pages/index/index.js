//index.js
//获取应用实例
const app = getApp();
var util = require('../../utils/util.js');

Page({
  data: {
    location: '',
    county: '',
    sliderList:[
      {selected:true, imageSource:'http://up.enterdesk.com/edpic/7d/35/13/7d3513ecabdf1f7eb4f1407f0e82f23c.jpg'},
      {selected:false, imageSource:'../../images/2.jpg'},
      {selected: false, imageSource: 'http://pic1.win4000.com/wallpaper/9/538544be6ae36.jpg'}
    ],
    today: '',
    inTheaters: {},
    containerShow: true,
    weatherData:'',
    air: '',
    dress: ''
  },
  
  onLoad: function () {
    // 获取当前日期
    app.globalData.day = util.formatTime(new Date()).split(' ')[0];
    this.setData({
      today: app.globalData.day
    });
    // 定位当前城市
    this.getLocation();
  },

  // 定位当前城市
  getLocation: function(){
    var that = this;
    wx.getLocation({
      type: 'wgs84',
      success: function(res) {
        let latitude = res.latitude
        let longitude = res.longitude
        wx.request({
          url: `https://apis.map.qq.com/ws/geocoder/v1/?location=${latitude},${longitude}&key=${app.globalData.tencentMapKey}`,
          success: res=>{
            console.log(res);
            app.globalData.defaultCity = app.globalData.defaultCity ? app.globalData.defaultCity : res.data.result.ad_info.city;
            app.globalData.defaultCounty = app.globalData.defaultCounty ? app.globalData.defaultCounty : res.data.result.ad_info.district;
            that.setData({
              location: app.globalData.defaultCity,
              county: app.globalData.defaultCounty  
            });
            that.getWeather();
            that.getAir();
          }
        })
      }
    })
  },

// 获取天气
  getWeather: function(){
    var length = this.data.location.length;
    var city = this.data.location.slice(0, length-1);
    console.log(city);
    var that = this;
    var param = {
      key: app.globalData.heWeatherKey,
      location:city
    };
    // 发出请求
    wx.request({
      url: app.globalData.heWeatherBase + '/s6/weather',
      data: param,
      header: {
        'content-type': 'application/json'
      },
      success: function(res){
        app.globalData.weatherData = res.data.HeWeather6[0].status == "unknown city" ? "":res.data.HeWeather6[0];
        var weatherData = app.globalData.weatherData ? app.globalData.weatherData : "暂无该城市天气";
        var dress = app.globalData.weatherData ? res.data.HeWeather6[0].lifestyle[1] : {txt: "暂无该城市生活指数信息"};
        that.setData({
          weatherData: weatherData,
          dress: dress
        })
      }
    })
  },

// 获取当前空气质量情况 
getAir: function(){
  var length = this.data.location.length;
  var city = this.data.location.slice(0,length-1);
  var that = this;
  var param = {
    key: app.globalData.heWeatherKey,
    location: city
  };
  wx.request({
    url: app.globalData.heWeatherBase + '/s6/air/now',
    data: param,
    header: {
      'content-type': 'application.json'
    },
    success: function(res){
      app.globalData.air = res.data.HeWeather6[0].status == "unknown city" ? "":res.data.HeWeather6[0].air_now_city;
      that.setData({
        air: app.globalData.air
      });
    }
  })
},

  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
