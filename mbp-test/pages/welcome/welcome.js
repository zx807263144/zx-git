// pages/welcome/welcome.js
Page({
  clickLogo:function(){
      wx.reLaunch({
        url: '/pages/index/index',
      })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
      return{
        title:"e生活",
        desc: "还没进去就想分享，我喜欢你这样的老铁",
        success:function(res){
          wx.showToast({
            title: '分享成功',
            duration: 1000,
            icon: "success"
          })
        }
      }
  }
})