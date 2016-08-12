package com.feicui.news.jsonhelper;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class CarGson {


    /**
     * postid : BU0RR6SF00084TUP
     * hasCover : false
     * hasHead : 1
     * replyCount : 1878
     * ltitle : 5系/A6L都胆颤?全新奔驰E级气场直逼S级
     * hasImg : 1
     * digest : 版权声明：本文版权为网易汽车所有，转载请注明出处。网易汽车8月9日报道在中国的中大型豪华车市场中，E级、A6、5系几乎形成三分天下的局势，近期如日中天的5系成为
     * hasIcon : true
     * docid : BU0RR6SF00084TUP
     * title : 5系/A6L都胆颤?全新奔驰E级气场直逼S级
     * order : 1
     * priority : 100
     * lmodify : 2016-08-09 08:56:43
     * auto_wap : [{"title":"汽车大全","imgsrc":"http://img2.cache.netease.com/m/newsapp/qichedaquan.png","subtitle":"All Cars","url":"http://auto.3g.163.com"},{"title":"购车指南","imgsrc":"http://img2.cache.netease.com/m/newsapp/zhidemai.png","subtitle":"Recommend","url":"http://auto.3g.163.com/bestsales/"},{"title":"创新工场","imgsrc":"http://img1.cache.netease.com/auto/2016/4/20/60-60.png","subtitle":"Innovation","url":"http://auto.163.com/special/inn/m_in_index.html"}]
     * boardid : auto_bbs
     * url_3w : http://auto.163.com/16/0809/07/BU0RR6SF00084TUP.html
     * template : normal1
     * votecount : 1611
     * alias : Autos
     * cid : C1348652751993
     * url : http://3g.163.com/auto/16/0809/07/BU0RR6SF00084TUP.html
     * hasAD : 1
     * source : 网易汽车
     * ename : qiche
     * subtitle :
     * imgsrc : http://cms-bucket.nosdn.127.net/d64ec8ddac5f419387e8d5de265b3b4a20160809081910.jpeg
     * tname : 汽车
     * ptime : 2016-08-09 07:23:00
     */

    private List<T1348654060988Bean> T1348654060988;

    public List<T1348654060988Bean> getT1348654060988() {
        return T1348654060988;
    }

    public void setT1348654060988(List<T1348654060988Bean> T1348654060988) {
        this.T1348654060988 = T1348654060988;
    }

    public static class T1348654060988Bean {
        private String digest;
        private String title;
        private String url_3w;
        private String url;
        private String imgsrc;

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
