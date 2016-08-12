package com.feicui.news.jsonhelper;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class JokeGson {


    /**
     * postid : BU18QTLO00964LQ9
     * hasCover : true
     * hasHead : 1
     * replyCount : 2618
     * ltitle : 轻松一刻:奥运最大赢家不是孙杨傅爷,是他
     * hasImg : 1
     * digest : 先来个捷报！孙杨男子200米自由泳冠军！傅园慧女子100米仰泳季军！徐嘉余男子100米仰泳亚军！15分钟一金一银一铜！奖牌来的太快，中国游泳队简直是一股龙卷风.
     * hasIcon : true
     * docid : BU18QTLO00964LQ9
     * title : 轻松一刻:奥运最大赢家不是孙杨傅爷,是他
     * order : 1
     * priority : 100
     * lmodify : 2016-08-09 13:34:35
     * boardid : 3g_bbs
     * url_3w : http://help.3g.163.com/16/0809/11/BU18QTLO00964LQ9.html
     * template : normal1
     * votecount : 1611
     * alias : FUNNY MOMENT
     * cid : C1348654575297
     * url : http://3g.163.com/ntes/16/0809/11/BU18QTLO00964LQ9.html
     * hasAD : 1
     * source : 轻松一刻工作室
     * subtitle :
     * ename : qingsongyike
     * tname : 轻松一刻
     * imgsrc : http://cms-bucket.nosdn.127.net/da5861f1b10244b291b4e7eb38d2ec9220160809111855.jpeg
     * ptime : 2016-08-09 11:10:02
     */

    private List<T1350383429665Bean> T1350383429665;

    public List<T1350383429665Bean> getT1350383429665() {
        return T1350383429665;
    }

    public void setT1350383429665(List<T1350383429665Bean> T1350383429665) {
        this.T1350383429665 = T1350383429665;
    }

    public static class T1350383429665Bean {
        private String digest;
        private String title;
        private String lmodify;
        private String url_3w;
        private String url;
        private String imgsrc;
        private String ptime;

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

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
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

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }
    }
}
