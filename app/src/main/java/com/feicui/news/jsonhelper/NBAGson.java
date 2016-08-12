package com.feicui.news.jsonhelper;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class NBAGson {

    /**
     * postid : BU0TN7KQ00050I18
     * hasCover : false
     * hasHead : 1
     * replyCount : 5330
     * ltitle : 美国44分轻取委内瑞拉2连胜 KD轰16+5
     * hasImg : 1
     * digest : 2016年里约奥运会男篮比赛继续进行，美国队拿到两连胜。乔治得到20分和4个篮板，杜兰特得到16分和5次助攻，他们带领球队在第二节打出小高潮确立优势，美国队以1
     * hasIcon : true
     * docid : BU0TN7KQ00050I18
     * title : 美国44分轻取委内瑞拉2连胜 KD轰16+5
     * order : 1
     * priority : 252
     * lmodify : 2016-08-09 08:11:47
     * boardid : sports2_bbs
     * url_3w : http://sports.163.com/16/0809/07/BU0TN7KQ00050I18.html
     * template : normal1
     * votecount : 5067
     * alias : NBA
     * cid : C1348649048655
     * url : http://3g.163.com/sports/16/0809/07/BU0TN7KQ00050I18.html
     * hasAD : 1
     * source : 网易体育
     * subtitle :
     * ename : NBA
     * tname : NBA
     * imgsrc : http://cms-bucket.nosdn.127.net/311d40d60a6b464f9fcff245e74b891120160809081047.jpeg
     * ptime : 2016-08-09 07:55:46
     */

    private List<T1348649145984Bean> T1348649145984;

    public List<T1348649145984Bean> getT1348649145984() {
        return T1348649145984;
    }

    public void setT1348649145984(List<T1348649145984Bean> T1348649145984) {
        this.T1348649145984 = T1348649145984;
    }

    public static class T1348649145984Bean {
        private String digest;
        private String title;
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
