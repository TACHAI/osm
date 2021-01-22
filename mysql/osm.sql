/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50560
Source Host           : 127.0.0.1:3306
Source Database       : osm

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2021-01-22 16:53:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_activity`
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `auther` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地点',
  `cover` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图',
  `activitytime` datetime DEFAULT NULL COMMENT '活动时间',
  `organizer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '主办单位',
  `detail` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '活动详情',
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '活动状态 0是正常1是下架',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 0是未删除1是已删除',
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES ('1', '新馆开放', '张老师', '火炬大道', null, null, '图书馆', '带好雨伞', '0', '2020-05-12 14:22:00', null, '1', null);
INSERT INTO `t_activity` VALUES ('2', '活动一', '给大哥', '是搭嘎十多个时高时低阿三哥是', '/static/uploadFile/image/banner1202005261733010.png', '2020-05-19 12:38:07', '搜嘎是个', '<p>三道杠三道杠三道杠收到广东省按个电视端ad 的</p>', '0', '2020-05-19 13:25:11', null, '1', null);
INSERT INTO `t_activity` VALUES ('3', '三道杠', '', '', '', '2020-05-19 13:39:03', '', '', '0', '2020-05-19 13:39:06', null, '1', null);
INSERT INTO `t_activity` VALUES ('4', '三道杠的', '十大歌手', '杀', '/static/uploadFile/image/404202005191342020.png', '2020-05-30 00:00:00', '三国杀', '<p>三道杠收到挂是搭嘎十多个</p>', '0', '2020-05-19 13:42:29', null, '1', null);
INSERT INTO `t_activity` VALUES ('5', null, null, null, null, null, null, null, '0', null, null, null, null);
INSERT INTO `t_activity` VALUES ('6', '三道杠给大哥', '', '的实施多个', '', '2020-05-19 14:39:03', '', '<p>是的归属感的故事大概</p>', '0', '2020-05-19 14:39:05', null, '1', null);
INSERT INTO `t_activity` VALUES ('7', '递归', '', '', '', '2020-05-19 15:08:54', '', '<p>递归三道杠山岗上的故事</p>', '0', '2020-05-19 15:08:57', null, '1', null);
INSERT INTO `t_activity` VALUES ('8', '搭嘎大纲', '', '', '', '2020-05-19 15:18:44', '', '<p>搭嘎大纲第三个撒个三道杠撒递归sad</p>', '0', '2020-05-19 15:18:50', null, '1', null);
INSERT INTO `t_activity` VALUES ('9', '是搭嘎十多个', '都是根深蒂固', '三道杠', '/static/uploadFile/image/404202005191522052.png', '2020-05-19 15:22:54', '三道杠', '<p><img src=\"../dev-api/static/uploadFile/image/电量202005200917039.png\" alt=\"\" width=\"200\" height=\"200\" />adsgsadg&nbsp;</p>', '1', '2020-05-19 15:22:59', null, '1', null);
INSERT INTO `t_activity` VALUES ('10', '的', '是的感受到', '是个', '/static/uploadFile/image/20191108103652_gfefqc90u3202006011034035.jpg', '2020-05-20 10:04:40', '三道杠', '<p>三道杠收到挂是搭嘎十多个</p>', '0', '2020-05-20 10:04:42', null, '1', null);
INSERT INTO `t_activity` VALUES ('11', '递归', '第三个', '', '', '2020-05-20 10:33:21', '', '<p>都是根深蒂固</p>', '0', '2020-05-20 10:33:22', null, '1', null);
INSERT INTO `t_activity` VALUES ('12', '的故事是个', '是搭嘎十多个', '是个', '/static/uploadFile/image/电量202005201036047.png', '2020-05-20 10:34:33', '十大歌手', '<p>第三个三国杀的搜嘎是个三道杠收到挂是搭嘎十多个<img src=\"../../dev-api/static/uploadFile/image/电量202005201039042.png\" /><img src=\"../../dev-api/static/uploadFile/image/杂志期刊202005201039042.png\" /><img src=\"../../dev-api/static/uploadFile/image/培训202005201039042.png\" /><img src=\"../../dev-api/static/uploadFile/image/摄影202005201039043.png\" /></p>', '0', '2020-05-20 10:34:51', null, '1', null);
INSERT INTO `t_activity` VALUES ('13', '读书活动', '撒郭德纲', '九江市图书馆一楼报告大厅', '/static/uploadFile/image/right_bottom_pic202006011152039.png', '2020-06-01 15:30:00', '九江市图书馆', '<p>山豆根山豆根山豆根山豆根山豆根山豆根是是的故事大纲盛顿国</p>', '0', '2020-06-01 11:53:48', null, '1', null);
INSERT INTO `t_activity` VALUES ('14', '九江市图书馆第三届古诗词大会线上报名', '死歌', '九江市图书馆寻庐小剧场', '/static/uploadFile/image/微信图片_20200611114151202006111147006.png', '2020-06-11 00:00:00', '九江市图书馆', '<p style=\"text-align: center;\">中华民族的传统文化源远流长，博大精深。经典古诗文作品，是中华传统文化的瑰宝，更是中华民族精神品格的真实写照。</p>\n<p><strong>活动对象：</strong>全体中小学生</p>\n<p><strong>活动时间：</strong><strong>2020</strong><strong>年6月20日开启首场比赛</strong></p>\n<p><strong>活动形式：</strong>活动分预赛、复赛、决赛进行小组赛</p>\n<p>预赛分8场，每场比赛有8组家庭进行对决；</p>\n<p>预赛取得前2名的家庭进入复赛</p>\n<p>（复赛2场，共16组家庭）；</p>\n<p>复赛取得前4名的家庭进入决赛</p>\n<p>（决赛1场，共8组家庭）</p>\n<p><strong>比赛方式：</strong>预赛每场比赛有三个环节，具体如下：</p>\n<p><strong>第一环节：</strong></p>\n<p>&ldquo;8进4&rdquo;&mdash;&mdash;8名选手上台比赛，完成8道必答题。得分排名前四的选手晋级。（如果有选手分数相同，无法确定前四名时，采取飞花令，依次淘汰。最终确定4名选手。下同。）</p>\n<p><strong>第二环节：</strong></p>\n<p>&ldquo;4进2&rdquo;&mdash;&mdash;4名选手参加比赛，题目类型为抢答题。在选手上一环节成绩基础上计分，分数排名前两名的选手晋级。</p>\n<p><strong>第三环节：</strong></p>\n<p>&ldquo;2进1&rdquo;&mdash;&mdash;此环节皆为必答题，两名选手依次答题，得分高者为本场比赛冠军。</p>\n<p><strong>&nbsp;</strong></p>', '0', '2020-06-02 08:57:50', null, '0', null);

-- ----------------------------
-- Table structure for `t_activity_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_user`;
CREATE TABLE `t_activity_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式 手机号',
  `detail` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '其他',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 0是未删除 1是已删除',
  PRIMARY KEY (`id`),
  KEY `activity_id_index` (`activity_id`),
  KEY `activity_id_phone_index` (`activity_id`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_activity_user
-- ----------------------------
INSERT INTO `t_activity_user` VALUES ('1', '9', 'dsgd', '15016464615', 'dgdg', '2020-05-19 16:41:23', null, '0');
INSERT INTO `t_activity_user` VALUES ('2', '14', '樟树', '13798478266', '缺一个上单', '2020-06-02 09:34:12', null, '0');
INSERT INTO `t_activity_user` VALUES ('3', '14', '樟树', '13798478266', '缺一个上单', '2020-06-02 09:34:23', null, '0');
INSERT INTO `t_activity_user` VALUES ('4', '14', '这个', '15866403976', '4949473818419194949', '2020-06-05 17:28:32', null, '0');
INSERT INTO `t_activity_user` VALUES ('5', '14', '九江', '13377777888', '无', '2020-06-09 10:28:04', null, '0');
INSERT INTO `t_activity_user` VALUES ('6', '14', '李四', '13767094798', '测试', '2020-06-11 11:57:55', null, '0');
INSERT INTO `t_activity_user` VALUES ('8', '13', '张恒', '15134554356', '九江', '2020-06-11 13:18:03', null, '0');
INSERT INTO `t_activity_user` VALUES ('9', '13', '张恒', '15134554356', '九江', '2020-06-11 13:18:05', null, '0');
INSERT INTO `t_activity_user` VALUES ('11', '14', '殷武', '17707928231', '小学和大家介绍介绍韩国哥哥哥哥和白白净净鞠躬感谢大家一直支持我们支持的', '2020-06-11 14:54:02', null, '0');
INSERT INTO `t_activity_user` VALUES ('12', '14', '刘浩哲', '13576224208', null, '2020-06-11 17:25:14', null, '0');
INSERT INTO `t_activity_user` VALUES ('13', '14', '周公哺', '13879281365', null, '2020-06-11 17:26:56', null, '0');
INSERT INTO `t_activity_user` VALUES ('14', '14', '周公哺', '13879281365', '九江小学八里湖校区二1班，陪同家长，龚思齐', '2020-06-11 17:29:13', null, '0');
INSERT INTO `t_activity_user` VALUES ('15', '14', '石云昊', '13870228574', '九江小学 四8班 陪同家长:杜荣娟', '2020-06-11 17:49:14', null, '0');
INSERT INTO `t_activity_user` VALUES ('17', '14', '徐子言', '15979989687', '东风小学五（四）班', '2020-06-11 18:09:37', null, '0');
INSERT INTO `t_activity_user` VALUES ('18', '14', '廖常清', '19979267038', null, '2020-06-11 18:18:34', null, '0');
INSERT INTO `t_activity_user` VALUES ('19', '14', '廖常清', '19979267038', null, '2020-06-11 18:18:38', null, '0');
INSERT INTO `t_activity_user` VALUES ('20', '14', '廖常清', '19979267038', '九江外国语学校初一', '2020-06-11 18:38:24', null, '0');
INSERT INTO `t_activity_user` VALUES ('21', '14', '易浩轩', '13970246585', null, '2020-06-11 18:42:55', null, '0');
INSERT INTO `t_activity_user` VALUES ('22', '14', '胡铭轩', '18720134737', null, '2020-06-11 18:50:59', null, '0');
INSERT INTO `t_activity_user` VALUES ('23', '14', '胡铭轩', '18720134737', null, '2020-06-11 18:51:02', null, '0');
INSERT INTO `t_activity_user` VALUES ('24', '14', '张弘毅', '18370251188', '与爸爸张胜军一起参赛', '2020-06-11 19:45:09', null, '0');
INSERT INTO `t_activity_user` VALUES ('25', '14', '张弘毅', '18370251188', '与爸爸张胜军一起参赛', '2020-06-11 19:45:17', null, '0');
INSERT INTO `t_activity_user` VALUES ('26', '14', '齐周睿', '13407929502', null, '2020-06-11 20:11:52', null, '0');

-- ----------------------------
-- Table structure for `t_back_live`
-- ----------------------------
DROP TABLE IF EXISTS `t_back_live`;
CREATE TABLE `t_back_live` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '直播标题',
  `introduction` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '介绍',
  `address` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '地点',
  `replay` int(11) DEFAULT NULL COMMENT '是否准许回看',
  `video_stream_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '视频流名称',
  `pull_stream_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '没有拼接过的流名称',
  `rtmp_pull_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT 'Rtmp拉流地址',
  `m3u8_pull_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT 'm3u8接流地址',
  `stram_id` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '流ID',
  `push_stram_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '推流地址',
  `file_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '直播数据数据主键',
  `mp4_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT 'mp4直播文件下载地址',
  `m3u8_address` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT 'm3u8文件下载地址',
  `notice_time` datetime DEFAULT NULL COMMENT '预告时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(5) DEFAULT NULL COMMENT '0是未删除1是已删除',
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_back_live
-- ----------------------------
INSERT INTO `t_back_live` VALUES ('1', '慕课直播', '测试直播', '高新大道', '0', 'NEWLIVET75280bwvdoid5271717110u09_vdoid5271717110u09', 'NEWLIVET75280bwvdoid5271717110u09', 'rtmp://rtmp-live.superlib.com/live/NEWLIVET75280bwvdoid5271717110u09', 'https://hls-live.superlib.com/live/NEWLIVET75280bwvdoid5271717110u09/index.m3u8', 'vdoid5271717110u09', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVET75280bwvdoid5271717110u09?signature=wcHpJcWZN%2BBRDDZenOtPoPNYX6A%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2221610404933&nonce=7538d7a482144ad3a519dc9b7baf578f&public=0&vdoid=vdoid5271717110u09', '7876173', 'https://ks3-cn-beijing.chaoxing.com/vdoid5271717110u09.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVET75280bwvdoid5271717110u09/hls/NEWLIVET75280bwvdoid5271717110u09-vdoid5271717110u09.m3u8', null, '2020-05-26 10:00:06', '2020-05-26 10:00:06', '0', null);
INSERT INTO `t_back_live` VALUES ('2', '的故事大概', '是个三道杠收到挂是搭嘎十多个sad噶是的', '是搭嘎十多个', '0', 'NEWLIVEN6Z426b3vdoid52818841833f3_vdoid52818841833f3', 'NEWLIVEN6Z426b3vdoid52818841833f3', 'rtmp://rtmp-live.superlib.com/live/NEWLIVEN6Z426b3vdoid52818841833f3', 'https://hls-live.superlib.com/live/NEWLIVEN6Z426b3vdoid52818841833f3/index.m3u8', 'vdoid52818841833f3', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVEN6Z426b3vdoid52818841833f3?signature=Sw1zohfpz0nFYWsg1zR8VklACww%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2221629111492&nonce=a176e69cb29549118bcdb243bd7f80fe&public=0&vdoid=vdoid52818841833f3', '7886560', 'https://ks3-cn-beijing.chaoxing.com/vdoid52818841833f3.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVEN6Z426b3vdoid52818841833f3/hls/NEWLIVEN6Z426b3vdoid52818841833f3-vdoid52818841833f3.m3u8', null, '2020-05-26 15:11:52', '2020-05-26 15:11:52', '0', null);
INSERT INTO `t_back_live` VALUES ('3', '第三个', '是个俺是个大as是', '三道杠', '0', 'NEWLIVE4s289W4Kvdoid52933578P30S8_vdoid52933578P30S8', 'NEWLIVE4s289W4Kvdoid52933578P30S8', 'rtmp://rtmp-live.superlib.com/live/NEWLIVE4s289W4Kvdoid52933578P30S8', 'https://hls-live.superlib.com/live/NEWLIVE4s289W4Kvdoid52933578P30S8/index.m3u8', 'vdoid52933578P30S8', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVE4s289W4Kvdoid52933578P30S8?signature=M4kFS9%2FxPgfxKveHENaDoKRUAkw%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2221693229100&nonce=806fa9623f664ef4998b5231b23f1930&public=0&vdoid=vdoid52933578P30S8', '7898512', 'https://ks3-cn-beijing.chaoxing.com/vdoid52933578P30S8.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVE4s289W4Kvdoid52933578P30S8/hls/NEWLIVE4s289W4Kvdoid52933578P30S8-vdoid52933578P30S8.m3u8', null, '2020-05-27 09:00:30', '2020-05-27 09:00:30', '0', null);
INSERT INTO `t_back_live` VALUES ('4', '是搭嘎十多个', '收到噶过过过过过过过过过过过过啥顶顶顶顶', '三个傻瓜撒', '0', 'NEWLIVEGKlT834vvdoid5293442Q6IEa9_vdoid5293442Q6IEa9', 'NEWLIVEGKlT834vvdoid5293442Q6IEa9', 'rtmp://rtmp-live.superlib.com/live/NEWLIVEGKlT834vvdoid5293442Q6IEa9', 'https://hls-live.superlib.com/live/NEWLIVEGKlT834vvdoid5293442Q6IEa9/index.m3u8', 'vdoid5293442Q6IEa9', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVEGKlT834vvdoid5293442Q6IEa9?signature=HY7U79QNzyoAHFy7ZC4btkutBi4%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2221693310947&nonce=0668e110f32d4e75b019db2cd6e61792&public=0&vdoid=vdoid5293442Q6IEa9', '7898597', 'https://ks3-cn-beijing.chaoxing.com/vdoid5293442Q6IEa9.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVEGKlT834vvdoid5293442Q6IEa9/hls/NEWLIVEGKlT834vvdoid5293442Q6IEa9-vdoid5293442Q6IEa9.m3u8', null, '2020-05-27 09:01:52', '2020-05-27 09:01:52', '0', null);
INSERT INTO `t_back_live` VALUES ('5', 'sdgdg', '', '', '0', 'NEWLIVE81981u4svdoid5382588knh4px_vdoid5382588knh4px', 'NEWLIVE81981u4svdoid5382588knh4px', 'rtmp://rtmp-live.superlib.com/live/NEWLIVE81981u4svdoid5382588knh4px', 'https://hls-live.superlib.com/live/NEWLIVE81981u4svdoid5382588knh4px/index.m3u8', 'vdoid5382588knh4px', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVE81981u4svdoid5382588knh4px?signature=WVclmx4b6Rel4Uiq6ybTNnvdzlg%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222147817636&nonce=36564ccbb2b14329b69e887ae4588069&public=0&vdoid=vdoid5382588knh4px', '7991086', 'https://ks3-cn-beijing.chaoxing.com/vdoid5382588knh4px.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVE81981u4svdoid5382588knh4px/hls/NEWLIVE81981u4svdoid5382588knh4px-vdoid5382588knh4px.m3u8', null, '2020-06-01 15:16:58', '2020-06-01 15:16:58', '0', null);
INSERT INTO `t_back_live` VALUES ('6', 'sgsgsdgsdg', '', '', '0', 'NEWLIVEhH5F69N8vdoid5382634W1ffxf_vdoid5382634W1ffxf', 'NEWLIVEhH5F69N8vdoid5382634W1ffxf', 'rtmp://rtmp-live.superlib.com/live/NEWLIVEhH5F69N8vdoid5382634W1ffxf', 'https://hls-live.superlib.com/live/NEWLIVEhH5F69N8vdoid5382634W1ffxf/index.m3u8', 'vdoid5382634W1ffxf', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVEhH5F69N8vdoid5382634W1ffxf?signature=LagfpZVD6qRU2m%2B0kPCi7uw4xaU%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222147887903&nonce=f2b414cb820f40299aae369255827f50&public=0&vdoid=vdoid5382634W1ffxf', '7991132', 'https://ks3-cn-beijing.chaoxing.com/vdoid5382634W1ffxf.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVEhH5F69N8vdoid5382634W1ffxf/hls/NEWLIVEhH5F69N8vdoid5382634W1ffxf-vdoid5382634W1ffxf.m3u8', null, '2020-06-01 15:18:08', '2020-06-01 15:18:08', '0', null);
INSERT INTO `t_back_live` VALUES ('8', 'dgdg', '', '', '0', 'NEWLIVE55w4VrOEvdoid5531400O52b66_vdoid5531400O52b66', 'NEWLIVE55w4VrOEvdoid5531400O52b66', 'rtmp://rtmp-live.superlib.com/live/NEWLIVE55w4VrOEvdoid5531400O52b66', 'https://hls-live.superlib.com/live/NEWLIVE55w4VrOEvdoid5531400O52b66/index.m3u8', 'vdoid5531400O52b66', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVE55w4VrOEvdoid5531400O52b66?signature=nv6XXCnmUgI99AdhPSjtOMCKzIs%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222933374621&nonce=a37eff9645074ea7bbbdd9f232017dad&public=0&vdoid=vdoid5531400O52b66', '8145460', 'https://ks3-cn-beijing.chaoxing.com/vdoid5531400O52b66.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVE55w4VrOEvdoid5531400O52b66/hls/NEWLIVE55w4VrOEvdoid5531400O52b66-vdoid5531400O52b66.m3u8', null, '2020-06-10 17:29:35', '2020-06-10 17:29:35', '0', null);
INSERT INTO `t_back_live` VALUES ('9', 'dgasdgdsg', '', '', '0', 'NEWLIVEmF956l85vdoid5531402i63kxH_vdoid5531402i63kxH', 'NEWLIVEmF956l85vdoid5531402i63kxH', 'rtmp://rtmp-live.superlib.com/live/NEWLIVEmF956l85vdoid5531402i63kxH', 'https://hls-live.superlib.com/live/NEWLIVEmF956l85vdoid5531402i63kxH/index.m3u8', 'vdoid5531402i63kxH', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVEmF956l85vdoid5531402i63kxH?signature=XsBF69Cy8hRvVfkvypOaBkJtpPA%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222933382358&nonce=fc49d35a73714f0d91784a8a982b3313&public=0&vdoid=vdoid5531402i63kxH', '8145462', 'https://ks3-cn-beijing.chaoxing.com/vdoid5531402i63kxH.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVEmF956l85vdoid5531402i63kxH/hls/NEWLIVEmF956l85vdoid5531402i63kxH-vdoid5531402i63kxH.m3u8', null, '2020-06-10 17:29:43', '2020-06-10 17:29:43', '0', null);
INSERT INTO `t_back_live` VALUES ('10', 'dgsdgasdg', '', '', '0', 'NEWLIVE53K2o737vdoid553140452P311_vdoid553140452P311', 'NEWLIVE53K2o737vdoid553140452P311', 'rtmp://rtmp-live.superlib.com/live/NEWLIVE53K2o737vdoid553140452P311', 'https://hls-live.superlib.com/live/NEWLIVE53K2o737vdoid553140452P311/index.m3u8', 'vdoid553140452P311', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVE53K2o737vdoid553140452P311?signature=jd%2Fn7T4DQknV4oDFucP5xvS0n88%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222933388929&nonce=2119841ba6fe488392a653a48717daf2&public=0&vdoid=vdoid553140452P311', '8145464', 'https://ks3-cn-beijing.chaoxing.com/vdoid553140452P311.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVE53K2o737vdoid553140452P311/hls/NEWLIVE53K2o737vdoid553140452P311-vdoid553140452P311.m3u8', null, '2020-06-10 17:29:49', '2020-06-10 17:29:49', '0', null);
INSERT INTO `t_back_live` VALUES ('11', 'dsgsdg', '', '', '0', 'NEWLIVEg1JHxocuvdoid5531406p8385Z_vdoid5531406p8385Z', 'NEWLIVEg1JHxocuvdoid5531406p8385Z', 'rtmp://rtmp-live.superlib.com/live/NEWLIVEg1JHxocuvdoid5531406p8385Z', 'https://hls-live.superlib.com/live/NEWLIVEg1JHxocuvdoid5531406p8385Z/index.m3u8', 'vdoid5531406p8385Z', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVEg1JHxocuvdoid5531406p8385Z?signature=io0TG0%2BBSbWDQssmGYufnwrVgq4%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2222933395028&nonce=82d861e213ad4504b42c955d6a48cfb2&public=0&vdoid=vdoid5531406p8385Z', '8145466', 'https://ks3-cn-beijing.chaoxing.com/vdoid5531406p8385Z.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVEg1JHxocuvdoid5531406p8385Z/hls/NEWLIVEg1JHxocuvdoid5531406p8385Z-vdoid5531406p8385Z.m3u8', null, '2020-06-10 17:29:55', '2020-06-10 17:29:55', '0', null);
INSERT INTO `t_back_live` VALUES ('12', '测试', '', '', '0', 'NEWLIVE66302R16vdoid5604272F6719M_vdoid5604272F6719M', 'NEWLIVE66302R16vdoid5604272F6719M', 'rtmp://rtmp-live.superlib.com/live/NEWLIVE66302R16vdoid5604272F6719M', 'https://hls-live.superlib.com/live/NEWLIVE66302R16vdoid5604272F6719M/index.m3u8', 'vdoid5604272F6719M', 'rtmp://ksuplive.chaoxing.com/live/NEWLIVE66302R16vdoid5604272F6719M?signature=mtBOfXJGF%2F00YpnqlZFM07z%2FCo8%3D&accesskey=YbAIvlTzp6KEbJnhukkT&expire=2223361373241&nonce=3aaae252fec34bd4902d45e2c3cc6b5a&public=0&vdoid=vdoid5604272F6719M', '8220581', 'https://ks3-cn-beijing.chaoxing.com/vdoid5604272F6719M.mp4', 'https://ks3-cn-beijing.chaoxing.com/record/live/NEWLIVE66302R16vdoid5604272F6719M/hls/NEWLIVE66302R16vdoid5604272F6719M-vdoid5604272F6719M.m3u8', null, '2020-06-15 16:22:53', '2020-06-15 16:22:53', '0', null);

-- ----------------------------
-- Table structure for `t_good`
-- ----------------------------
DROP TABLE IF EXISTS `t_good`;
CREATE TABLE `t_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `live_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '有效状态 0是有效 1是无效',
  PRIMARY KEY (`id`),
  KEY `good_user_id_index` (`user_id`),
  KEY `good_live_id_index` (`live_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_good
-- ----------------------------
INSERT INTO `t_good` VALUES ('1', null, null, '2020-05-28 15:50:21', '0');
INSERT INTO `t_good` VALUES ('2', null, null, '2020-05-28 15:51:52', '0');
INSERT INTO `t_good` VALUES ('4', null, null, '2020-05-28 15:52:56', '0');
INSERT INTO `t_good` VALUES ('5', null, null, '2020-05-28 15:53:11', '0');
INSERT INTO `t_good` VALUES ('6', null, null, '2020-05-28 15:55:03', '0');
INSERT INTO `t_good` VALUES ('7', null, '3', '2020-05-28 15:55:43', '0');
INSERT INTO `t_good` VALUES ('8', null, '3', '2020-05-28 15:55:56', '0');
INSERT INTO `t_good` VALUES ('9', null, '2', '2020-05-28 15:55:56', '0');
INSERT INTO `t_good` VALUES ('10', null, '1', '2020-05-28 15:55:57', '0');
INSERT INTO `t_good` VALUES ('11', null, '2', '2020-05-28 15:56:13', '0');
INSERT INTO `t_good` VALUES ('12', null, '3', '2020-05-28 15:56:26', '0');
INSERT INTO `t_good` VALUES ('13', null, '3', '2020-05-28 15:59:56', '0');
INSERT INTO `t_good` VALUES ('14', null, '3', '2020-05-28 16:00:44', '0');
INSERT INTO `t_good` VALUES ('15', null, '3', '2020-05-28 16:01:04', '0');
INSERT INTO `t_good` VALUES ('16', null, '3', '2020-05-28 16:01:44', '0');
INSERT INTO `t_good` VALUES ('17', null, '3', '2020-05-28 16:04:47', '0');

-- ----------------------------
-- Table structure for `t_live`
-- ----------------------------
DROP TABLE IF EXISTS `t_live`;
CREATE TABLE `t_live` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `cover` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '封面图',
  `replay` int(5) DEFAULT NULL COMMENT '是否回放0是回放1是不回放',
  `auther` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `video` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '视频',
  `introduction` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '介绍',
  `address` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '地点',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL COMMENT '0是未删除1是已删除',
  `pv` int(11) DEFAULT NULL COMMENT '观看次数',
  `status` int(11) DEFAULT NULL COMMENT '上下架',
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_live
-- ----------------------------
INSERT INTO `t_live` VALUES ('1', '慕课直播', '/static/uploadFile/image/banner202005281444047.png', '0', '王盼', '', '测试直播', '高新大道', '2020-05-26 10:00:06', null, '1', '7', '2', null);
INSERT INTO `t_live` VALUES ('2', '的故事大概', '/static/uploadFile/image/banner1202005281444041.png', '0', '都是根深蒂固', '', '是个三道杠收到挂是搭嘎十多个sad噶是的', '是搭嘎十多个', '2020-05-26 15:11:52', null, '1', '12', '2', null);
INSERT INTO `t_live` VALUES ('3', '第三个', '/static/uploadFile/image/电量202005270922035.png', '0', '是搭嘎十多个', '', '是个俺是个大as是', '三道杠', '2020-05-27 09:00:30', null, '1', '29', '2', null);
INSERT INTO `t_live` VALUES ('4', '是搭嘎十多个', '/static/uploadFile/image/bg202005270902001.png', '0', '三道杠', '/static/uploadFile/video/852888piChdt202005270920055.mp4', '收到噶过过过过过过过过过过过过啥顶顶顶顶', '三个傻瓜撒', '2020-05-27 09:01:52', null, '1', '22', '2', null);
INSERT INTO `t_live` VALUES ('5', 'sdgdg', '/static/uploadFile/image/icon4202006011516054.png', '0', '', '', '', '', '2020-06-01 15:16:58', null, '1', '2', '2', null);
INSERT INTO `t_live` VALUES ('6', 'sgsgsdgsdg', '/static/uploadFile/image/icon1202006011518006.png', '0', '', '', '', '', '2020-06-01 15:18:08', null, '1', '8', '2', null);
INSERT INTO `t_live` VALUES ('7', '直播测试', '/static/uploadFile/image/丘氏重修族谱202006101327055.png', '0', '三个', '', '山豆根山豆根山豆根山豆根收到是德国盛顿国', '山豆根山豆s\'d\'g', '2020-06-10 13:28:04', null, '1', '4', '2', null);
INSERT INTO `t_live` VALUES ('8', 'dgdg', '/static/uploadFile/image/avatar202006101729034.jpg', '0', '', '', '', '', '2020-06-10 17:29:35', null, '1', '1', '2', null);
INSERT INTO `t_live` VALUES ('9', 'dgasdgdsg', '/static/uploadFile/image/thumbnail202006101729042.jpg', '0', '', '', '', '', '2020-06-10 17:29:43', null, '1', '2', '2', null);
INSERT INTO `t_live` VALUES ('10', 'dgsdgasdg', '/static/uploadFile/image/avatar202006101729048.jpg', '0', '', '', '', '', '2020-06-10 17:29:49', null, '1', '3', '2', null);
INSERT INTO `t_live` VALUES ('11', '《琵琶行》鉴赏 01', '/static/uploadFile/image/寻庐讲坛logo(1)202006111455019202006161519003.jpg', '0', '蔡厚淳', '/static/uploadFile/video/4 《琵琶行》鉴赏01202006161517042.mp4', '', '', '2020-06-10 17:29:55', null, '0', '160', '2', null);
INSERT INTO `t_live` VALUES ('12', '测试', '/static/uploadFile/image/banner1202006151622049.png', '0', '', '/static/uploadFile/video/20200610151445_o30rkl3nk8202006151623028.mp4', '', '', '2020-06-15 16:22:53', null, '1', '1', '2', null);

-- ----------------------------
-- Table structure for `t_live_reservation`
-- ----------------------------
DROP TABLE IF EXISTS `t_live_reservation`;
CREATE TABLE `t_live_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上下架 0上架1下架',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cover` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `author` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_live_reservation
-- ----------------------------
INSERT INTO `t_live_reservation` VALUES ('1', '寻庐讲坛', '/static/uploadFile/image/favicon202012080914003.ico', '', '1', null, null, null);

-- ----------------------------
-- Table structure for `t_test_paper`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_paper`;
CREATE TABLE `t_test_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '试卷名',
  `auther` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `introduction` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '介绍',
  `examtime` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '考试时间',
  `insert_time` datetime DEFAULT NULL COMMENT '新建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(255) DEFAULT NULL COMMENT '是否删除0 未删除1是已删除',
  `status` int(11) DEFAULT NULL,
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_test_paper
-- ----------------------------
INSERT INTO `t_test_paper` VALUES ('1', '试卷一', '上岗大概', '三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥三道杠撒个傻瓜搜嘎是个大哥大哥哥', '100', '2020-05-20 14:09:20', '2020-06-01 14:14:11', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('2', '试卷二', '实打实大概', '是的噶啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '60', '2020-05-27 09:26:02', '2020-06-01 14:14:12', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('3', '试卷三', '是个', '管道撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '42', '2020-05-27 09:29:32', '2020-06-01 14:14:13', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('4', '试卷四', '十大歌手', '是个', '1', '2020-05-27 09:29:40', '2020-06-01 14:14:14', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('5', '试卷五', '搜嘎是个', '', '1', '2020-05-27 09:29:49', '2020-06-01 14:14:14', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('6', '试卷六', '是个', '', '1', '2020-05-27 09:29:58', '2020-06-01 14:14:15', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('7', '试卷七', '是个', '', '1', '2020-05-27 09:30:07', '2020-06-01 14:14:16', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('8', '试卷八', '的', '', '1', '2020-05-27 09:30:15', '2020-06-01 14:14:16', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('9', '试卷九', '三道杠是个的', '', '1', '2020-05-27 09:30:22', '2020-06-01 14:14:17', '1', null, null);
INSERT INTO `t_test_paper` VALUES ('10', '试卷十', '感受到', '', '8', '2020-05-27 09:30:32', '2020-06-01 14:14:18', '1', null, null);

-- ----------------------------
-- Table structure for `t_test_paper_answer`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_paper_answer`;
CREATE TABLE `t_test_paper_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL COMMENT '题目id',
  `option` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '选项例 A',
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答案',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `test_paper_question_id_index` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_test_paper_answer
-- ----------------------------
INSERT INTO `t_test_paper_answer` VALUES ('2', '2', null, '选项二', '2020-05-21 09:04:52');
INSERT INTO `t_test_paper_answer` VALUES ('3', '2', null, '选项三搜索', '2020-05-21 09:10:34');
INSERT INTO `t_test_paper_answer` VALUES ('4', '2', null, '选项一', '2020-05-21 09:15:42');
INSERT INTO `t_test_paper_answer` VALUES ('6', '7', null, '十多个傻瓜', '2020-05-21 09:30:54');
INSERT INTO `t_test_paper_answer` VALUES ('7', '7', null, '是根深蒂固撒嘎嘎', '2020-05-21 09:31:02');
INSERT INTO `t_test_paper_answer` VALUES ('8', '2', null, '是的归属感', '2020-05-27 09:32:54');
INSERT INTO `t_test_paper_answer` VALUES ('9', '10', null, '不是（）真确答案', '2020-06-01 14:17:47');
INSERT INTO `t_test_paper_answer` VALUES ('10', '10', null, '是', '2020-06-01 14:17:51');
INSERT INTO `t_test_paper_answer` VALUES ('11', '11', null, '张三', '2020-06-01 14:18:14');
INSERT INTO `t_test_paper_answer` VALUES ('12', '11', null, '李四', '2020-06-01 14:18:23');
INSERT INTO `t_test_paper_answer` VALUES ('13', '11', null, '王五', '2020-06-01 14:18:31');
INSERT INTO `t_test_paper_answer` VALUES ('14', '11', null, '都不是', '2020-06-01 14:18:38');
INSERT INTO `t_test_paper_answer` VALUES ('15', '12', null, '没有人写（正确答案）', '2020-06-01 14:19:56');
INSERT INTO `t_test_paper_answer` VALUES ('16', '12', null, '张三', '2020-06-01 14:20:03');
INSERT INTO `t_test_paper_answer` VALUES ('17', '12', null, '李四', '2020-06-01 14:20:09');
INSERT INTO `t_test_paper_answer` VALUES ('18', '13', null, '李四', '2020-06-01 14:20:25');
INSERT INTO `t_test_paper_answer` VALUES ('19', '13', null, '王二', '2020-06-01 14:20:33');
INSERT INTO `t_test_paper_answer` VALUES ('20', '13', null, '张三的儿子（正确答案）', '2020-06-01 14:20:47');
INSERT INTO `t_test_paper_answer` VALUES ('21', '13', null, '麻子', '2020-06-01 14:20:53');
INSERT INTO `t_test_paper_answer` VALUES ('22', '14', null, '张三', '2020-06-01 15:07:08');
INSERT INTO `t_test_paper_answer` VALUES ('23', '14', null, '星期一（真确答案）', '2020-06-01 15:07:17');
INSERT INTO `t_test_paper_answer` VALUES ('24', '14', null, '星期二', '2020-06-01 15:07:27');
INSERT INTO `t_test_paper_answer` VALUES ('25', '14', null, '星期三', '2020-06-01 15:07:39');
INSERT INTO `t_test_paper_answer` VALUES ('26', '17', null, '100000', '2020-06-11 14:29:31');
INSERT INTO `t_test_paper_answer` VALUES ('27', '17', null, '100000', '2020-06-11 14:29:40');
INSERT INTO `t_test_paper_answer` VALUES ('28', '17', null, '100000', '2020-06-11 14:29:47');
INSERT INTO `t_test_paper_answer` VALUES ('29', '19', null, 'A秦国', '2020-06-16 14:27:25');
INSERT INTO `t_test_paper_answer` VALUES ('30', '19', null, 'B魏国', '2020-06-16 14:27:37');
INSERT INTO `t_test_paper_answer` VALUES ('31', '19', null, 'C楚国', '2020-06-16 14:27:45');
INSERT INTO `t_test_paper_answer` VALUES ('32', '19', null, 'D赵国', '2020-06-16 14:27:50');

-- ----------------------------
-- Table structure for `t_test_paper_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_paper_log`;
CREATE TABLE `t_test_paper_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  `answer_type` int(11) DEFAULT NULL,
  `answer_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_test_paper_log
-- ----------------------------
INSERT INTO `t_test_paper_log` VALUES ('1', '19', '21', '68', null, '0', '');
INSERT INTO `t_test_paper_log` VALUES ('2', '19', '21', '69', null, '1', '666');
INSERT INTO `t_test_paper_log` VALUES ('3', '19', '20', '68', '224', '0', '');
INSERT INTO `t_test_paper_log` VALUES ('4', '19', '20', '69', null, '1', '一国两制是基本国策');
INSERT INTO `t_test_paper_log` VALUES ('5', '19', '22', '68', null, '0', '');
INSERT INTO `t_test_paper_log` VALUES ('6', '19', '22', '69', null, '1', '历史总是在重复');
INSERT INTO `t_test_paper_log` VALUES ('7', '19', '29', '68', '222', '0', '222');
INSERT INTO `t_test_paper_log` VALUES ('8', '19', '29', '69', null, '1', '武统台湾');

-- ----------------------------
-- Table structure for `t_test_paper_mark`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_paper_mark`;
CREATE TABLE `t_test_paper_mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `test_paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  `mark` int(11) DEFAULT NULL COMMENT '分叔成绩',
  `cost_time` int(11) DEFAULT NULL COMMENT '考卷所需用时',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `test_paper_mark_question_id_user_id_index` (`test_paper_id`,`wx_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_test_paper_mark
-- ----------------------------
INSERT INTO `t_test_paper_mark` VALUES ('1', '1', '1', '10', null, null);
INSERT INTO `t_test_paper_mark` VALUES ('2', '1', '12', '0', null, null);
INSERT INTO `t_test_paper_mark` VALUES ('3', null, '13', '10', null, null);
INSERT INTO `t_test_paper_mark` VALUES ('4', null, '13', '5', null, null);
INSERT INTO `t_test_paper_mark` VALUES ('5', '3', '13', '0', null, null);
INSERT INTO `t_test_paper_mark` VALUES ('6', null, '14', '5', null, '2020-06-01 15:28:50');
INSERT INTO `t_test_paper_mark` VALUES ('7', null, '14', '0', null, '2020-06-01 15:29:39');
INSERT INTO `t_test_paper_mark` VALUES ('8', null, '14', '0', null, '2020-06-01 16:14:08');
INSERT INTO `t_test_paper_mark` VALUES ('9', null, '14', '0', null, '2020-06-01 16:20:38');
INSERT INTO `t_test_paper_mark` VALUES ('10', null, '14', '0', null, '2020-06-01 16:45:07');
INSERT INTO `t_test_paper_mark` VALUES ('11', '17', '14', '0', null, '2020-06-01 17:06:24');
INSERT INTO `t_test_paper_mark` VALUES ('12', null, '14', '5', null, '2020-06-01 17:28:51');
INSERT INTO `t_test_paper_mark` VALUES ('13', null, '14', '5', null, '2020-06-01 19:05:58');
INSERT INTO `t_test_paper_mark` VALUES ('14', null, '14', '0', null, '2020-06-01 21:33:02');
INSERT INTO `t_test_paper_mark` VALUES ('15', null, '14', '5', null, '2020-06-02 08:36:20');
INSERT INTO `t_test_paper_mark` VALUES ('16', '18', '14', '5', null, '2020-06-02 09:35:20');
INSERT INTO `t_test_paper_mark` VALUES ('17', null, '14', '5', null, '2020-06-02 14:48:45');
INSERT INTO `t_test_paper_mark` VALUES ('18', null, '14', '5', null, '2020-06-04 12:46:05');
INSERT INTO `t_test_paper_mark` VALUES ('19', null, '14', '0', null, '2020-06-05 17:28:41');
INSERT INTO `t_test_paper_mark` VALUES ('20', '20', '14', '5', null, '2020-06-08 09:23:48');
INSERT INTO `t_test_paper_mark` VALUES ('21', null, '14', '5', null, '2020-06-08 16:45:25');
INSERT INTO `t_test_paper_mark` VALUES ('22', '21', '14', '0', null, '2020-06-09 10:48:05');
INSERT INTO `t_test_paper_mark` VALUES ('23', '23', '14', '0', null, '2020-06-10 19:53:05');

-- ----------------------------
-- Table structure for `t_test_paper_question`
-- ----------------------------
DROP TABLE IF EXISTS `t_test_paper_question`;
CREATE TABLE `t_test_paper_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) DEFAULT NULL,
  `question_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '题目',
  `answer_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答案详解',
  `answer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答案例如 A',
  `point` int(11) DEFAULT NULL COMMENT '分数',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '题目类型，例文学',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` int(255) DEFAULT NULL COMMENT '是否删除 0是未删除1是已删除',
  PRIMARY KEY (`id`),
  KEY `test_paper_question_paper_id_question_name_index` (`paper_id`,`question_name`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_test_paper_question
-- ----------------------------
INSERT INTO `t_test_paper_question` VALUES ('1', '1', '都是噶时代感', '', '', '6', '', '2020-05-20 16:58:25', '2020-05-20 17:05:52', '1');
INSERT INTO `t_test_paper_question` VALUES ('2', '1', '题目一', '解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析解析', '3', '5', '', '2020-05-20 17:06:51', '2020-05-21 09:34:14', '0');
INSERT INTO `t_test_paper_question` VALUES ('3', '1', '是搭嘎十多个', '', '', '6', '', '2020-05-20 17:10:47', '2020-05-21 09:29:56', '1');
INSERT INTO `t_test_paper_question` VALUES ('4', '1', '刚三道杠撒蛋糕师', '', '', '1', '', '2020-05-20 17:14:41', '2020-05-21 09:29:56', '1');
INSERT INTO `t_test_paper_question` VALUES ('5', '1', '试卷二', '', '', '5', '', '2020-05-20 17:15:51', '2020-05-21 09:29:55', '1');
INSERT INTO `t_test_paper_question` VALUES ('6', '1', '第三个', '', '', '1', '', '2020-05-20 17:16:10', '2020-05-21 09:29:54', '1');
INSERT INTO `t_test_paper_question` VALUES ('7', '1', '三国杀是个是个是个', '十多个杀三个', '6', '5', '', '2020-05-21 09:30:33', '2020-05-21 09:31:04', '0');
INSERT INTO `t_test_paper_question` VALUES ('8', '1', '三道杠撒个', '', '', '1', '', '2020-05-21 09:31:28', null, '0');
INSERT INTO `t_test_paper_question` VALUES ('9', '1', '都是根深蒂固', '', '', '1', '', '2020-05-21 09:34:08', null, '0');
INSERT INTO `t_test_paper_question` VALUES ('10', '13', '儿童节是国际节日吗', '我也不知道', '9', '5', '', '2020-06-01 14:16:41', '2020-06-01 14:19:21', '0');
INSERT INTO `t_test_paper_question` VALUES ('11', '13', '儿童节是谁建立的', '展示', '14', '5', '', '2020-06-01 14:16:56', '2020-06-01 14:18:54', '0');
INSERT INTO `t_test_paper_question` VALUES ('12', '13', '格林童话是谁写的', '是多少', '15', '5', '', '2020-06-01 14:17:15', '2020-06-01 14:20:16', '0');
INSERT INTO `t_test_paper_question` VALUES ('13', '13', '张三的儿子是谁', '1212', '20', '5', '', '2020-06-01 14:17:30', '2020-06-01 14:21:01', '0');
INSERT INTO `t_test_paper_question` VALUES ('14', '14', '今天星期几', '对', '23', '5', '', '2020-06-01 15:06:56', '2020-06-01 15:07:57', '0');
INSERT INTO `t_test_paper_question` VALUES ('15', '14', '答题', '', '', '1', '', '2020-06-11 14:26:33', null, '0');
INSERT INTO `t_test_paper_question` VALUES ('16', '14', '1', '', '', '100', '', '2020-06-11 14:27:36', null, '0');
INSERT INTO `t_test_paper_question` VALUES ('17', '15', '1千米等于多少厘米', '', '', '10', '', '2020-06-11 14:29:14', null, '0');
INSERT INTO `t_test_paper_question` VALUES ('18', '15', '1+1=？', '', '', '10', '', '2020-06-12 14:10:54', '2020-06-12 14:10:57', '1');
INSERT INTO `t_test_paper_question` VALUES ('19', '16', '屈原是我国春秋时期哪国人', '', '31', '5', '', '2020-06-16 14:26:06', '2020-06-16 14:28:07', '0');
INSERT INTO `t_test_paper_question` VALUES ('20', '16', '端午节有为小孩佩香囊的习惯，大人在香囊内放朱砂、雄黄、香药等代表的意义是什么？', '', '36', '5', '', '2020-06-16 14:26:35', '2020-06-16 14:31:36', '0');
INSERT INTO `t_test_paper_question` VALUES ('21', '16', '南方的粽子一般是什么口味？', '', '38', '5', '', '2020-06-16 14:31:50', '2020-06-16 14:32:21', '0');
INSERT INTO `t_test_paper_question` VALUES ('22', '16', '古人端午节涂饮雄黄酒的意义是？', '', '42', '5', '', '2020-06-16 14:32:51', '2020-06-16 14:33:22', '0');
INSERT INTO `t_test_paper_question` VALUES ('23', '16', '最早的粽子并不是端午节的特产，那粽子是什么时期被正式定为端午节食品的？', '', '44', '5', '', '2020-06-16 15:13:22', '2020-06-16 15:13:55', '0');
INSERT INTO `t_test_paper_question` VALUES ('24', '16', '赛龙舟是端午节的主要习俗之一，相传起源于古代楚国人因舍不得贤臣屈原投江死去，许多人划船追赶拯救。其实，“龙舟竞渡”早在（）时期就有了', '', '51', '5', '', '2020-06-16 15:14:10', '2020-06-16 15:14:50', '0');
INSERT INTO `t_test_paper_question` VALUES ('25', '16', '下列哪项不是端午节的习俗？', '', '54', '5', '', '2020-06-16 15:15:03', '2020-06-16 15:15:38', '0');
INSERT INTO `t_test_paper_question` VALUES ('26', '16', '1+1', '1+1=2地球人都知道', '56', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:49', '1');
INSERT INTO `t_test_paper_question` VALUES ('27', '16', '1+2', '1+1=3地球人都知道', '60', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:48', '1');
INSERT INTO `t_test_paper_question` VALUES ('28', '16', '1+3', '1+1=4地球人都知道', '64', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:47', '1');
INSERT INTO `t_test_paper_question` VALUES ('29', '16', '1+4', '1+1=5地球人都知道', '68', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:47', '1');
INSERT INTO `t_test_paper_question` VALUES ('30', '16', '1+5', '1+1=6地球人都知道', '72', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:46', '1');
INSERT INTO `t_test_paper_question` VALUES ('31', '16', '1+6', '1+1=7地球人都知道', '76', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:46', '1');
INSERT INTO `t_test_paper_question` VALUES ('32', '16', '1+7', '1+1=8地球人都知道', '80', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:45', '1');
INSERT INTO `t_test_paper_question` VALUES ('33', '16', '1+8', '1+1=9地球人都知道', '84', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:44', '1');
INSERT INTO `t_test_paper_question` VALUES ('34', '16', '1+9', '1+1=10地球人都知道', '88', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:44', '1');
INSERT INTO `t_test_paper_question` VALUES ('35', '16', '1+10', '1+1=11地球人都知道', '92', '5', null, '2020-06-16 17:49:33', '2020-06-16 17:49:43', '1');
INSERT INTO `t_test_paper_question` VALUES ('36', '16', '1+11', '1+1=12地球人都知道', '96', '5', null, '2020-06-16 17:49:34', '2020-06-16 17:49:42', '1');
INSERT INTO `t_test_paper_question` VALUES ('37', '16', '1+12', '1+1=13地球人都知道', '100', '5', null, '2020-06-16 17:49:34', '2020-06-16 17:49:41', '1');
INSERT INTO `t_test_paper_question` VALUES ('38', '16', '1+13', '1+1=14地球人都知道', '104', '5', null, '2020-06-16 17:49:34', '2020-06-16 17:49:40', '1');
INSERT INTO `t_test_paper_question` VALUES ('39', '16', '1+14', '1+1=15地球人都知道', '108', '5', null, '2020-06-16 17:49:34', '2020-06-16 17:49:40', '1');
INSERT INTO `t_test_paper_question` VALUES ('40', '16', '1+1', '1+1=2地球人都知道', '112', '5', null, '2020-06-16 19:09:00', '2020-06-16 19:09:21', '1');

-- ----------------------------
-- Table structure for `t_unit`
-- ----------------------------
DROP TABLE IF EXISTS `t_unit`;
CREATE TABLE `t_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `unit_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `unit_wx_appid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `unit_wx_key` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `unit_app` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `unit_detail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_unit
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '是否删除 0是未删除1是已删除',
  `unit_id` int(11) DEFAULT NULL,
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'AB2385DD1F310B9C2995687B10162B73', '1', '2020-01-02 16:56:53', null, '0', null, null);

-- ----------------------------
-- Table structure for `t_vote`
-- ----------------------------
DROP TABLE IF EXISTS `t_vote`;
CREATE TABLE `t_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '投票活动名称',
  `introduction` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '介绍',
  `cover` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `organizer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '主办单位',
  `status` int(11) DEFAULT NULL COMMENT '上下架  0是已上架1是下架',
  `votetime` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '投票时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否 删除 0是未删除1是已删除',
  `vstart_time` datetime DEFAULT NULL COMMENT '投票开始时间',
  `vend_time` datetime DEFAULT NULL COMMENT '投票结束时间',
  `ustart_time` datetime DEFAULT NULL COMMENT '上传开始时间',
  `uend_time` datetime DEFAULT NULL COMMENT '上传结束时间',
  `unit_uuid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_vote
-- ----------------------------
INSERT INTO `t_vote` VALUES ('1', null, null, null, null, null, null, '2020-05-15 11:29:54', null, '1', null, null, null, null, null);
INSERT INTO `t_vote` VALUES ('2', '的发挥地方', '', '', '', '0', null, '2020-05-15 16:12:21', null, '1', '2020-05-15 16:12:20', '2020-05-15 16:12:22', '2020-05-15 16:12:16', '2020-05-15 16:12:18', null);
INSERT INTO `t_vote` VALUES ('3', '的发挥地方', '', '', '', '0', null, '2020-05-15 16:12:32', null, '1', '2020-05-15 16:12:20', '2020-05-15 16:12:22', '2020-05-15 16:12:16', '2020-05-15 16:12:18', null);
INSERT INTO `t_vote` VALUES ('4', '都干啥干啥干啥', '是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个', '', '哥哥是个', '0', null, '2020-05-18 08:46:41', null, '1', '2020-05-18 08:46:46', '2020-05-18 08:46:48', '2020-05-18 08:46:44', '2020-05-18 08:46:45', null);
INSERT INTO `t_vote` VALUES ('5', '都干啥干啥干啥', '是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个 是干啥干啥干啥干啥三国杀是格式是是个', '', '哥哥是个', '0', null, '2020-05-18 08:46:49', null, '1', '2020-05-18 08:46:46', '2020-05-18 08:46:48', '2020-05-18 08:46:44', '2020-05-18 08:46:45', null);
INSERT INTO `t_vote` VALUES ('6', 'sgsg', '', '', '', '0', null, '2020-05-18 08:51:29', null, '1', '2020-05-18 08:51:34', '2020-05-18 08:51:36', '2020-05-18 08:51:31', '2020-05-22 00:00:00', null);
INSERT INTO `t_vote` VALUES ('7', 'sdgsgsdg', 'sdgsdgsdg', '/static/uploadFile/image/404202005180946055.png', 'sdgsdg', '0', null, '2020-05-18 09:47:09', null, '1', '2020-05-18 09:47:12', '2020-05-18 09:47:13', '2020-05-18 09:47:06', '2020-05-18 09:47:08', null);
INSERT INTO `t_vote` VALUES ('8', 'sdgsgsdg', 'sdgsdgsdg', '', 'sdgsdg', '0', null, '2020-05-18 09:47:35', null, '1', '2020-05-18 09:47:12', '2020-05-18 09:47:13', '2020-05-03 14:04:02', '2020-05-29 14:04:04', null);
INSERT INTO `t_vote` VALUES ('9', 'sdgsgsdg', 'sdgsdgsdg', '/static/uploadFile/image/404202005180946055.png', 'sdgsdg', '0', null, '2020-05-18 09:48:58', null, '1', '2020-05-18 09:47:12', '2020-05-18 09:47:13', '2020-05-18 09:47:06', '2020-05-18 09:47:08', null);
INSERT INTO `t_vote` VALUES ('10', 'sdgsg', 'sdgsdg', '', '', '0', null, '2020-05-18 09:49:12', null, '1', '2020-05-18 09:49:19', '2020-05-18 09:49:20', '2020-05-18 09:49:16', '2020-05-18 09:49:17', null);
INSERT INTO `t_vote` VALUES ('11', '傻大哥哥', '', '', '', '0', null, '2020-05-18 11:24:12', null, '1', '2020-05-18 11:24:09', '2020-05-18 11:24:11', '2020-05-18 11:24:04', '2020-05-18 11:24:07', null);
INSERT INTO `t_vote` VALUES ('12', '多个', '', '', '', '0', null, '2020-05-18 11:25:38', null, '1', '2020-05-18 11:25:33', '2020-05-18 11:25:32', '2020-05-18 11:25:35', '2020-05-18 11:25:36', null);
INSERT INTO `t_vote` VALUES ('13', '傻大哥哥', '第三个', '', '', '0', null, '2020-05-18 14:16:40', null, '1', '2020-05-18 14:16:36', '2020-05-18 14:16:37', '2020-05-18 14:16:33', '2020-05-18 14:16:34', null);
INSERT INTO `t_vote` VALUES ('14', '孤独根深蒂固是挂是搭嘎十多个三道杠三道杠三道杠收到高', '三道杠三道杠三道杠收到', '/static/uploadFile/image/banner202005251041048.png', '得高高的', '0', null, '2020-05-18 14:17:23', null, '1', '2020-05-18 14:17:21', '2020-05-18 14:17:22', '2020-05-18 16:35:03', '2020-05-30 14:17:19', null);
INSERT INTO `t_vote` VALUES ('15', '的身高多少', '收到噶所过所多过撒多过过过过过过过过过过过过搜嘎多多多多多多多多多多多多多多多多是个大啊啊啊啊啊啊啊啊啊啊啊啊啊啊搜嘎多多多多多多多多多多多多多多多多多多多多多多多多多是个大啊啊啊啊啊啊啊啊啊啊身高多啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊是个大啊啊啊啊啊啊啊啊啊啊啊搜嘎多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多是个', '/static/uploadFile/image/banner202005251041055.png', '', '0', null, '2020-05-18 14:17:33', null, '1', '2020-05-18 14:17:31', '2020-05-18 14:17:32', '2020-05-18 14:17:29', '2020-05-18 14:17:30', null);
INSERT INTO `t_vote` VALUES ('16', '搭嘎大纲', 'sdgsdgsdgsdgasdgasdgasdg', '/static/uploadFile/image/banner1202005251042001.png', 'dsgsdgasdgasdg', '0', null, '2020-05-18 14:17:43', null, '1', '2020-05-18 14:17:41', '2020-05-18 14:17:42', '2020-05-18 14:17:39', '2020-05-18 14:17:40', null);
INSERT INTO `t_vote` VALUES ('17', '是搭嘎十多个', 'sdgsdgsagsg', '/static/uploadFile/image/banner1202005251042014.png', 'sdgaaaaaaaaagsd', '0', null, '2020-05-18 14:17:53', null, '1', '2020-05-18 14:17:51', '2020-05-18 14:17:52', '2020-05-18 14:17:49', '2020-05-18 14:17:50', null);
INSERT INTO `t_vote` VALUES ('18', '是搭嘎十多个', 'sdgsadgdg', '/static/uploadFile/image/bg202005251042025.png', '', '0', null, '2020-05-18 14:18:01', null, '1', '2020-05-18 14:17:59', '2020-05-18 14:18:00', '2020-05-18 14:17:57', '2020-05-18 14:17:58', null);
INSERT INTO `t_vote` VALUES ('19', '是都干啥的管道是根深蒂固', 'sdgsagasdg', '/static/uploadFile/image/banner1202005251042031.png', '', '0', null, '2020-05-18 14:18:12', null, '1', '2020-05-18 14:18:09', '2020-05-18 14:18:10', '2020-05-18 14:18:07', '2020-05-18 14:18:08', null);
INSERT INTO `t_vote` VALUES ('20', '是搭嘎十多个', '', '/static/uploadFile/image/banner202005251056001.png', '', '0', null, '2020-05-18 14:18:21', null, '1', '2020-05-18 14:18:19', '2020-05-18 14:18:20', '2020-05-18 14:18:17', '2020-05-18 14:18:18', null);
INSERT INTO `t_vote` VALUES ('21', '三道杠', '三道杠', '', '', '0', null, '2020-05-18 14:18:32', null, '1', '2020-05-18 14:18:29', '2020-05-18 14:18:31', '2020-05-18 14:18:27', '2020-05-18 14:18:28', null);
INSERT INTO `t_vote` VALUES ('22', '广东省理工技术的公司', '水果萨达干啥的时高时低故事的故事东港市是个是收到根深蒂固是个是个是个身高多', '/static/uploadFile/image/banner202005250925044.png', '搜嘎是个', '0', null, '2020-05-25 09:25:53', null, '1', '2020-05-25 09:25:51', '2020-05-25 09:25:52', '2020-05-25 09:25:48', '2020-05-25 09:25:49', null);
INSERT INTO `t_vote` VALUES ('23', '是个是根深蒂固', '丧尸国度山岗上的故事个三道杠撒个', '/static/uploadFile/image/banner1202005250926004.png', '第三个三国杀的个', '0', null, '2020-05-25 09:26:11', null, '1', '2020-05-25 09:26:09', '2020-05-25 09:26:10', '2020-05-25 09:26:06', '2020-05-25 09:26:08', null);
INSERT INTO `t_vote` VALUES ('24', '三道杠撒个傻瓜傻瓜', '三道杠撒搭嘎是个时代感', '/static/uploadFile/image/banner1202005250926031.png', '三道杠收到挂是搭嘎十多个是递归', '0', null, '2020-05-25 09:26:38', null, '1', '2020-05-25 09:26:36', '2020-05-25 09:26:37', '2020-05-25 09:26:34', '2020-05-25 09:26:35', null);
INSERT INTO `t_vote` VALUES ('25', '都是根深蒂固是递归的观点公司的故事大概是三道杠三道杠三道杠收到广东省个是的感受到三道杠三道杠sad噶是的噶是的', '是管道是搭嘎十多个', '/static/uploadFile/image/banner1202005261737040.png', '都是根深蒂固是', '0', null, '2020-05-25 09:26:54', null, '1', '2020-05-25 09:26:50', '2020-05-25 09:26:52', '2020-05-25 09:26:47', '2020-05-25 09:26:51', null);
INSERT INTO `t_vote` VALUES ('26', '这是第一个测试作品数据', '<p><span class=\"ql-cursor\">﻿﻿﻿﻿﻿﻿</span><span style=\"color: rgb(136, 136, 136);\">青少儿“抗击新型冠状病毒肺炎”主题图形创意设计大赛</span></p><p><span style=\"color: rgb(136, 136, 136);\">投稿时间：截止2020年7月10日</span></p><p><span style=\"color: rgb(136, 136, 136);\">作品要求：</span></p><p><span style=\"color: rgb(136, 136, 136);\">作品原件大小：A4（21*29.7cm）或A3（29.7*42cm）&nbsp;</span></p><p><span style=\"color: rgb(136, 136, 136);\">统一以电子文件提交方式提交作品，提交内容包括如下：&nbsp;</span></p><p><span style=\"color: rgb(136, 136, 136);\">01：电子版作品图片或照片，拍摄要求正面平行拍摄，画面干净整洁。</span></p><p><span style=\"color: rgb(136, 136, 136);\">02：请参赛选手妥善保管好作品原件，如通过评审获奖，组委会将举办获奖作品展览及相关画册设计。</span><span class=\"ql-cursor\">﻿﻿﻿﻿﻿﻿﻿﻿</span></p>', '/static/uploadFile/image/sub_module5202006011111008.png', '九江市图书馆', '0', null, '2020-06-01 11:12:13', null, '0', '2020-06-01 08:00:00', '2020-07-31 00:00:00', '2020-06-01 08:00:00', '2020-07-31 00:00:00', null);

-- ----------------------------
-- Table structure for `t_vote_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_vote_user`;
CREATE TABLE `t_vote_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `vote_id` int(11) DEFAULT NULL COMMENT '投票活动id',
  `vote_work_id` int(11) DEFAULT NULL COMMENT '投票作品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `vote_id_user_id` (`vote_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_vote_user
-- ----------------------------
INSERT INTO `t_vote_user` VALUES ('1', '17', '26', '16', '2020-06-01 17:06:03');
INSERT INTO `t_vote_user` VALUES ('2', '18', '26', '16', '2020-06-02 09:34:09');
INSERT INTO `t_vote_user` VALUES ('3', '21', '26', '16', '2020-06-09 10:40:41');
INSERT INTO `t_vote_user` VALUES ('4', '37', '26', '17', '2020-06-12 21:09:50');
INSERT INTO `t_vote_user` VALUES ('5', '61', '26', '25', '2020-06-17 13:48:12');
INSERT INTO `t_vote_user` VALUES ('6', '64', '26', '30', '2020-06-17 16:37:45');

-- ----------------------------
-- Table structure for `t_vote_work`
-- ----------------------------
DROP TABLE IF EXISTS `t_vote_work`;
CREATE TABLE `t_vote_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_id` int(11) DEFAULT NULL COMMENT '投票活动id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作品名',
  `cover` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `auther` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作者',
  `pv` int(11) DEFAULT NULL COMMENT '投票次数',
  `introduction` text COLLATE utf8_bin COMMENT '介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL,
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除 0是未删除1是已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_vote_work
-- ----------------------------
INSERT INTO `t_vote_work` VALUES ('1', '14', '递归', '/static/uploadFile/image/404202005191118059.png', '三道杠sg', null, 0x3C703E647367647367647367673C2F703E0A3C703EE98092E5BD923C2F703E0A3C703E3C61207469746C653D22E983ADE5BEB7E7BAB2E582BBE7939CE698AFE4B8AA2220687265663D222E2E2F2E2E2F6465762D6170692F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F41646D696E4C54452D6D61737465723230323030353230303933343032372E7A6970223E41646D696E4C54452D6D61737465723C2F613E3C2F703E, '2020-05-18 16:35:38', null, '0');
INSERT INTO `t_vote_work` VALUES ('2', '14', '是东港市递归收到', '/static/uploadFile/image/avatar202005181735047.gif', '是搭嘎十多个啥', null, 0x3C703EE4B89CE6B8AFE5B882E98092E5BD92E694B6E588B0E698AFE4B8AAE698AFE4B8AAE698AFE4B8AAE4B889E4B8AAE582BBE7939C3C2F703E, '2020-05-18 17:37:14', null, '0');
INSERT INTO `t_vote_work` VALUES ('3', '14', '都是根深蒂固是', '/static/uploadFile/image/404202005181737021.png', '收到挂是搭嘎十多个啥', null, 0x3C703EE698AFE4B89CE6B8AFE5B882E98092E5BD92E694B6E588B03C2F703E, '2020-05-18 17:37:25', null, '0');
INSERT INTO `t_vote_work` VALUES ('4', '14', '水果萨达干啥的', '/static/uploadFile/image/404202005181737032.png', '三道杠撒递归三道杠', null, 0x3C703EE698AFE690ADE5988EE58D81E5A49AE4B8AAE595A5E5A4A7E6A682E6B492E5A4A7E6A6823C2F703E, '2020-05-18 17:37:37', null, '0');
INSERT INTO `t_vote_work` VALUES ('5', '14', '三道杠撒搭嘎是个', '/static/uploadFile/image/avatar202005181737044.gif', '是个是搭嘎十多个啥大概洒大概', null, 0x3C703EE4B889E98193E69DA0E69292E690ADE5988EE58D81E5A49AE4B8AAE890A8E5988EE694B6E588B03C2F703E, '2020-05-18 17:37:48', null, '0');
INSERT INTO `t_vote_work` VALUES ('6', '14', '三道杠撒gas递归', '/static/uploadFile/image/avatar202005181737054.gif', '三道杠撒递归sad', null, 0x3C703EE58D81E5A49AE4B8AAE69D80E4B889E4B8AA3C2F703E, '2020-05-18 17:37:59', null, '0');
INSERT INTO `t_vote_work` VALUES ('7', '14', '三道杠撒大概啥时', '/static/uploadFile/image/404202005181738005.png', '三道杠撒个傻瓜', null, 0x3C703EE698AFE690ADE5988EE58D81E5A49AE4B8AAE6A0B9E6B7B1E89282E59BBAE5958A3C2F703E, '2020-05-18 17:38:14', null, '0');
INSERT INTO `t_vote_work` VALUES ('8', '14', '是的噶是搭嘎十多个', '/static/uploadFile/image/404202005181738021.png', '三道杠撒蛋糕师', null, 0x3C703EE4B889E98193E69DA0E69292E4B8AAE69292E690ADE5988EE58D81E5A49AE4B8AA3C2F703E, '2020-05-18 17:38:27', null, '0');
INSERT INTO `t_vote_work` VALUES ('9', '14', '三个傻大哥撒旦', '/static/uploadFile/image/404202005181738033.png', '三道杠撒递归sad干撒大概', null, 0x3C703EE4B889E4B8AAE582BBE5A4A7E593A5E69292E697A6E6849FE58F97E588B03C2F703E, '2020-05-18 17:38:38', null, '0');
INSERT INTO `t_vote_work` VALUES ('10', '14', '是个啥公司的公司ad', '/static/uploadFile/image/404202005181738044.png', '是个三道杠撒递归sad个', null, 0x3C703EE4B889E4B8AAE582BBE5A4A7E593A5E69292E697A6E4B8AA3C2F703E, '2020-05-18 17:38:48', null, '0');
INSERT INTO `t_vote_work` VALUES ('11', '14', '大概多少个', '/static/uploadFile/image/电量202005200906022.png', '电视广告', null, 0x3C703E3C766964656F20636F6E74726F6C733D22636F6E74726F6C73222077696474683D2233303022206865696768743D22313530223E0A3C736F75726365207372633D222E2E2F6465762D6170692F7374617469632F75706C6F616446696C652F766964656F2F3835323838387069436864743230323030353230303930363030362E6D70342220747970653D22766964656F2F6D703422202F3E3C2F766964656F3E3C2F703E, '2020-05-20 09:06:23', null, '0');
INSERT INTO `t_vote_work` VALUES ('12', '14', '的三个傻大哥撒旦', '/static/uploadFile/image/电量202005200928040.png', '搜嘎是个', null, 0x3C703EE4B889E98193E69DA0E694B6E588B0E68C82E698AFE690ADE5988EE58D81E5A49AE4B8AA3C2F703E, '2020-05-20 09:28:51', null, '0');
INSERT INTO `t_vote_work` VALUES ('13', '14', '三道杠', '/static/uploadFile/image/电量202005201047028.png', '收到该公司', null, 0x3C703EE698AFE79A84E6849FE58F97E588B0E599B6E595A5E698AFE79A84E599B6E6909CE5988E3C2F703E, '2020-05-20 10:47:34', null, '0');
INSERT INTO `t_vote_work` VALUES ('14', '14', '三道杠', '/static/uploadFile/image/电量202005201049005.png', '身高多', null, 0x3C703EE4B889E4B8AAE582BBE5A4A7E593A5E69292E697A6E6849FE58F97E588B0E4B8AA3C2F703E, '2020-05-20 10:49:09', null, '0');
INSERT INTO `t_vote_work` VALUES ('15', '14', '的固定格式', '/static/uploadFile/image/banner1202005261738013.png', '第三个', null, 0x3C703EE5B9B2E59388E8BEBEE59388E79A84E5908EE4BBA3E698AFE590A6E59088E98082E59CB0E696B9E8BF98E698AFE794B5E8AF9DE8B4B9E983BDE68896E5A49AE68896E5B091E983BDE5BE88E68782E4BA8B3C2F703E, '2020-05-20 10:50:17', null, '0');
INSERT INTO `t_vote_work` VALUES ('16', '26', '最强作品', '/static/uploadFile/image/C652ED40-CA2B-43A3-965C-71EDBB77079A202006011113011.png', '无名氏', '3', 0x3C7020636C6173733D2222207374796C653D22223EE590ACE4BDA0E8BF99E8BF98E694AFE694AFE590BEE590BE696E67E9BE87E78999E592A7E598B4E8BF87E4B880E998B5E5AD903C2F703E3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F36464537364535372D413039422D344435432D394641342D3938463637343030313441343230323030363031313131333034342E6769662220636C6173733D22223E, '2020-06-01 11:14:08', '2020-06-17 14:00:29', '1');
INSERT INTO `t_vote_work` VALUES ('17', '26', '六一儿童节', '/static/uploadFile/image/9D892751-A9B5-4C46-8072-FBB36CCE79E4202006011114058.gif', '李四', '1', '', '2020-06-01 11:15:08', '2020-06-17 14:00:29', '1');
INSERT INTO `t_vote_work` VALUES ('18', '26', '测试', '/static/uploadFile/image/Screenshot_20200531_154218_com.android.browser202006011148024.jpg', '陈公民', '0', 0x3C7020636C6173733D2222207374796C653D22223EE7BB99E4BDA0E5819AE6988EE6988EE593A6E593A6E6988EE593A6E38082E590BCE590BCE590BCE591A8E585B1E5928CE58FAAE4B8BAE4BDA0E6B395E588B6E5AEA3E4BCA03C2F703E3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F696D672D64626363393032393761363230363934373430636238626364323233386561373230323030363031313134393030342E6A70672220636C6173733D22223E, '2020-06-01 11:49:14', '2020-06-12 14:00:03', '1');
INSERT INTO `t_vote_work` VALUES ('19', '26', '清文', '/static/uploadFile/image/1592113204286202006141340028.jpg', '张煜杰', '0', 0x3C7020636C6173733D2222207374796C653D22223EE4BDA0E5A5BDE591803C2F703E, '2020-06-14 13:42:27', '2020-06-15 16:24:43', '1');
INSERT INTO `t_vote_work` VALUES ('20', '26', '名字', '/static/uploadFile/image/416F4CBA-4D5C-43BF-9D89-4D439C696F24202006171109005.gif', '测试', '0', 0x3C7020636C6173733D2222207374796C653D22223EE683A0E6B091E8BF98E4B880E79BB4E598BBE598BBE598BBE598BBE598BBE5908EE69E9CE5BE88E4B8A5E9878D3C2F703E, '2020-06-17 11:09:18', '2020-06-17 14:00:31', '1');
INSERT INTO `t_vote_work` VALUES ('21', '26', '迷宫', '/static/uploadFile/image/FEB0C791-A816-486B-9C32-CFE5D517D256202006171109054.gif', '明年', '0', 0x3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F44443335343531312D413146302D343334372D383939412D3033303432323530333438433230323030363137313131303030382E6769662220636C6173733D22223E3C70207374796C653D22666F6E742D73697A653A20313870783B223EE4BDA0E4BBA5E4B8BAE4BE9DE784B6E59CA8E4B880E8B5B7E997AEE4B880E4B88BE6B88DE6B88DE6B88DE8A681E4B880E79BB4E4B880E79BB4E68891E4B880E585B1E4BDA0E59180E4B880E79BB4E4B880E79BB4E59CA8E4B880E8B5B7E6B88DE6B88DE6B88DE598A4E598A4E598A4E68891E6B88DE6B88DE6B88DE4B880E79BB4E59CA8E598BBE598BBE598BBE598BBE598BBE598BBE598BB3C2F703E, '2020-06-17 11:10:31', '2020-06-17 14:00:33', '1');
INSERT INTO `t_vote_work` VALUES ('22', '26', '测试作品列表是个是根深蒂固是东港市递归收到三道杠', '/dev-api/static/uploadFile/image/banner202006171141047.png', '是的杠杆第三个是的感受到', '0', 0x3C7020636C6173733D2222207374796C653D22223E7364677364677361643C2F703E, '2020-06-17 11:42:29', '2020-06-17 11:43:46', '1');
INSERT INTO `t_vote_work` VALUES ('23', '26', '工', '/static/uploadFile/image/753306A2-2645-4FBD-998C-024E11E917DD202006171145004.gif', '好好工作', '0', 0x3C7020636C6173733D2222207374796C653D22223EE5B7A5E8B5843C2F703E3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F44423934344639352D304237352D344332302D393837412D4636453334313035313839443230323030363137313134353031372E676966223E, '2020-06-17 11:45:21', '2020-06-17 14:00:33', '1');
INSERT INTO `t_vote_work` VALUES ('24', '26', 'dg', '/static/uploadFile/image/banner202006171247051.png', 'dsgsgsg', '0', 0x3C7020636C6173733D2222207374796C653D22223E7364677364676173646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464646464643C2F703E, '2020-06-17 12:47:59', '2020-06-17 14:00:34', '1');
INSERT INTO `t_vote_work` VALUES ('25', '26', 'sdg', '/static/uploadFile/image/banner1202006171303004.png', 'dsgsdg', '1', 0x3C7020636C6173733D2222207374796C653D22223E73646761616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161613C2F703E, '2020-06-17 13:03:12', '2020-06-17 14:00:30', '1');
INSERT INTO `t_vote_work` VALUES ('26', '26', 'csjjxjjd', '/static/uploadFile/image/IMG_20200614_224330202006171348042.jpg', '李嘉栎', '0', 0x3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F494D475F32303230303631345F3232343234303230323030363137313334383035332E6A7067223E, '2020-06-17 13:48:55', '2020-06-17 14:00:35', '1');
INSERT INTO `t_vote_work` VALUES ('27', '26', '张三的夏天', '/static/uploadFile/image/B1A1F37F-B460-46EF-A7C2-7C6B2BCE91A5202006171354034.gif', '张三', '0', 0x3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F38463644394243352D413435302D343541332D383530412D4533394445363132343335343230323030363137313335353030342E6A706567223E, '2020-06-17 13:55:09', '2020-06-17 14:00:36', '1');
INSERT INTO `t_vote_work` VALUES ('28', '26', '测试投稿', '/static/uploadFile/image/1592373386133202006171356038.jpg', '应该', '0', 0x3C7020636C6173733D2222207374796C653D22223EE6B58BE8AF95E68A95E7A8BF3C2F703E3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F494D475F32303230303631325F3135303932313230323030363137313335373032342E6A7067223E, '2020-06-17 13:57:26', '2020-06-17 14:00:21', '1');
INSERT INTO `t_vote_work` VALUES ('29', '26', 'msjks', '/static/uploadFile/image/IMG_20200613_135936_mh1592059889351202006171358006.jpg', 'hejsj', '0', 0x3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F494D475F32303230303631335F3133353730305F6D68313539323035393835353738383230323030363137313335383031382E6A7067223E, '2020-06-17 13:58:31', '2020-06-17 14:00:36', '1');
INSERT INTO `t_vote_work` VALUES ('30', '26', '测试数据', '/static/uploadFile/image/F2CAE42F-5DC6-4882-8F12-93D21AD0A69B202006171635019.png', '张三', '1', 0x3C696D672077696474683D223130302522206865696768743D226175746F22207372633D222F7374617469632F75706C6F616446696C652F6F746865725265736F757263652F44363839344335342D414344322D344245392D384338412D3437374638463835334446463230323030363137313633353034342E6A7065672220636C6173733D22223E3C70207374796C653D226C696E652D6865696768743A20312E383B20746578742D616C69676E3A206C6566743B20646973706C61793A20626C6F636B3B20666F6E742D73697A653A20313870783B206261636B67726F756E642D636F6C6F723A20696E68657269743B20746578742D6465636F726174696F6E3A20696E68657269743B20666F6E742D7765696768743A206E6F726D616C3B20636F6C6F723A20726762283132312C2038352C203732293B2220636C6173733D22223E266E6273703B20266E6273703B20266E6273703B20266E6273703BE4B98BE4B880E4BABAE4B98BE4B88BE4B880E79BB4E4B880E79BB4E59CA8E4B880E8B5B7E598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE598BBE4B880E6A0B7E79A84E6B88DE6B88DE6B88DE4B880E79BB4E4BBA5E4B8BAE4B880E5AD97E59E8BE4B880E79BB4E4BBA5E4B8BAE887AAE7BB99E887AAE8B6B3E4B880E79BB4E59CA8E68891E4B880E79BB4E4BBA5E4B8BAE58FAFE4BBA5E4B880E5AD97E59E8B77E69893E4BFA1E4B893E7BABFE4B880E5AD97E59E8BE58F8BE8B08AE8B7AFE8A5BFE4BA94E5B7B7E5BC82E7958CE4B98BE4B99DE998B3E79C9FE7BB8F3C2F703E3C6469763E3C62723E3C2F6469763E3C64697620636C6173733D2222207374796C653D22666F6E742D7765696768743A206E6F726D616C3B20666F6E742D73697A653A20313870783B20636F6C6F723A20726762283132312C2038352C203732293B206C696E652D6865696768743A20323B223E266E6273703B20266E6273703B20266E6273703B20266E6273703B676F676F676FE5BE88E887AAE794B1E4BDA0E5B18BE5A4B4E78B97E78B97E6ACA2E8BF8EE4BDA0E6B091E68891E8818CE5B7A5E4B98BE5AEB6E696B0E6B58EE585ACE58FABE688914C4F4CE58CBFE5908D696E67E4B880E5AD97E59E8B3C2F6469763E3C703E3C2F703E, '2020-06-17 16:37:27', null, '0');

-- ----------------------------
-- Table structure for `t_wx_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_user`;
CREATE TABLE `t_wx_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `pickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `province` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `headimgurl` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_wx_user
-- ----------------------------
INSERT INTO `t_wx_user` VALUES ('16', 'os1l4wP6eBfsqRxxlSgxGBMj_V6k', '梵落', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep9iaycU7YfLr4dySukYGDAKPcGQBSrCL308q7XibRXd0FIgnWQknRxiblSdUKNUjibp3eic8miaXYd754Q/132', '2020-06-01 16:17:31');
INSERT INTO `t_wx_user` VALUES ('17', 'os1l4wDdwxabDMzQa-RWBECvO-TE', '塔拆', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqIcL7cPj0vNupkQ3xKN2NUToRc4z8GPia3t0dXcgA491oGXnf0CMxxicugYb4xIuPGntyeghGw8UFA/132', '2020-06-01 16:44:40');
INSERT INTO `t_wx_user` VALUES ('18', 'os1l4wGdZJtGlz6As7RSSgafWoEY', '寅潇', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epgy9F5tmH2fwDIT0wupUJ2XrXDjUEWRZPQR6O7xnUNR7ZAQ4icGTicJZUlcNv9WKbHkzPIJibviaP01w/132', '2020-06-02 09:34:07');
INSERT INTO `t_wx_user` VALUES ('19', 'os1l4wIAZpxWiohDK3Xn8BLiNQXY', '魏燕龙', '1', '', null, '泽西岛', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJv1rq4SGSnXxtjTS7APueT8GQ82zoMw6aAPNRt84wpaoGQjF3H9Nz4m4EKuFE3d9jhc8ib7sXBd0Q/132', '2020-06-04 16:57:41');
INSERT INTO `t_wx_user` VALUES ('20', 'os1l4wFZw2PxHJu74F00UybeN4y8', '徐小俊', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI8M1ksB6ib5KInYhNP6iaxicWE7UKOSya340kKmeqVkHtWdJ9flmQNw7LSlzTH8Ao5YnZbpYEyXIunw/132', '2020-06-08 09:23:43');
INSERT INTO `t_wx_user` VALUES ('21', 'os1l4wDi5kjqQ4jy3MBYmdgYeCHo', 'zh', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKdpkticRhiakFgxoDuV5hRyyTGe7HAQzvHKQbS8KdESAkUcFM6ic3gPJHRUpicVBfibib92HmHicoynrzAg/132', '2020-06-09 10:40:31');
INSERT INTO `t_wx_user` VALUES ('22', 'os1l4wHn1o_X4X7ExrwkJ-ozYvpk', '刘帅', '1', '安徽', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKU0MC8lDhUl1vmBcD8YOzjLgwruXmaiaWiaicZhpibR7XYPWj9I3EMiaEqachalW8icVZt48NdOD2l9PJA/132', '2020-06-10 17:08:19');
INSERT INTO `t_wx_user` VALUES ('23', 'os1l4wJDgjZjQrciwTWIS3CliYbA', '曾森林', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epHffUM48icw9aa66AASOd5BcBbo7HUEjJv5ccIdI88v2Dh9S6icIqZacEPj1chmjTfgIEcNDjaT0pA/132', '2020-06-10 19:53:03');
INSERT INTO `t_wx_user` VALUES ('24', 'os1l4wLiH239Ei1Vp3pwq1JbWRT8', '宋岩', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eq7a56whPWxsyVy2RsicTxbr2Sz7GGysdfibzib7kngNskft5HzdFO9qlR3OaS2qvCNZ6v1uEZ57LFqw/132', '2020-06-11 10:16:30');
INSERT INTO `t_wx_user` VALUES ('25', 'os1l4wFVvkDK85HaCHA6hZA7ymF4', '姜慧', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL5X4Qd53LmYLnID2w5khoQBqNXZMHygmj0CrhLoibGGHI14kHm9FoW0R2iaRX3KTXGcB9PH7thoZyQ/132', '2020-06-11 16:18:21');
INSERT INTO `t_wx_user` VALUES ('26', 'os1l4wNrfIlA8XdG0woeCekKr9ls', '果妈', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK6HfBvHWHX6OLOKeVvsHJt7QqSNpEWFQ4icGM0ATpYAnial7rKTnmuEbT5ibaNL5s9JvhuUzheO0oZw/132', '2020-06-11 18:09:46');
INSERT INTO `t_wx_user` VALUES ('28', 'os1l4wB-vZKxypbhTWjEh1dSfumQ', '熊永生', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKyHLn0FnSHBkntdLG2CcYibg8ze7gOQY9BYG6FActPy0zwvaEGqwnxNgibtyuTKPffQd6yqporoOicQ/132', '2020-06-11 19:18:46');
INSERT INTO `t_wx_user` VALUES ('29', 'os1l4wNTL6WniEJESjyxsrh8-o3o', 'Linda', '2', '浙江', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/LPn898RCDy89F5z6OnZZ2TCW3RQzuG7pQYLx1Qt2WOZt8hDH1TC0u28cYySbaDt09iaf0QogNvnemT3QmpYgvYw/132', '2020-06-11 20:19:07');
INSERT INTO `t_wx_user` VALUES ('30', 'os1l4wMdCi0PlN92BL2kF3ZtLjpE', '灵', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLtLfzx8n8XamZVo5Rw7plRD54aDICDTgkwjEWNRdparILdC6zg1ylIKvWsqVeryQaliawOx4zkC2w/132', '2020-06-11 21:56:40');
INSERT INTO `t_wx_user` VALUES ('31', 'os1l4wNOdmuTNe8SWQ7E9e-G7Ra4', 'simin', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ4Mg9HAJ5au36hB0yUlZ1QwqoD8sicZ6RX1OTSg0FKPzMxxULqbNFy03tFTBaehYk2BLIeAvEfttw/132', '2020-06-11 22:32:47');
INSERT INTO `t_wx_user` VALUES ('32', 'os1l4wIDnNVeT_ZXUA4mnuFTrSGI', '陈飞', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoVVo7p10WtM9edCJmmjaRcVwiaNjD0ZvkFP9rnqbNXMRAe1RRQV70szkrM5lQqO8Pic4wAlWNLtibrw/132', '2020-06-11 22:58:29');
INSERT INTO `t_wx_user` VALUES ('33', 'os1l4wH9RDu2xCFtdNgYBwlcjScQ', '小刀刀', '2', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI26CtZLfW9EKKoAiaibZxVRib5gwzBQwWxAOPsNaOtXUAGHibRfVDPgYKiaFS64W3hJhqvo1NYrVgRWlQ/132', '2020-06-12 09:16:15');
INSERT INTO `t_wx_user` VALUES ('34', 'os1l4wIzxAdO65wPEejDccPabXWU', '夏青', '1', '江西', null, '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI9ZGEs3EQWUGtDos0mp5DuZQmq5apQBe3HlOjZP2QrCia2d6NhrMMMwXSH5XfRf3ZdxSr4giaJGVHQ/132', '2020-06-12 09:17:05');
INSERT INTO `t_wx_user` VALUES ('35', 'os1l4wLE96N4x1xCGAhmZ7MWfBrY', '睿智思维训练营 Ms Zhao', '2', '', null, '新加坡', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIFricMEe1scyYHyrvSTXp5ATS7XVzWOuHH6Br44WMd2Nic8hOe8e8TWCmfMRfSicI7dyU42WRibooBMQ/132', '2020-06-12 12:32:51');
INSERT INTO `t_wx_user` VALUES ('36', 'os1l4wK998KoV5B1XBhP2llclC5c', '祝东风', '0', '', null, '', 'http://thirdwx.qlogo.cn/mmopen/vi_32/tro5ojiaUYicNo92HboFhVlfleUpveR139e7LW6YCMgFTK3pDLxjJvUZiaRj9oE1D8Vq4FPNAbQNFQmoezLcgW0vw/132', '2020-06-12 14:22:37');
INSERT INTO `t_wx_user` VALUES ('37', 'os1l4wMzrGFCJvMyWHvkJqxhvdGI', '@Txy', '2', '吉隆坡', null, '马来西亚', 'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eraYbaM2lNBubPBGHGt4xrts6mGSmicwEEdKks3CI0bYn5W5VTAczMk5w2QXmnFwy058mCrsZpA7xA/132', '2020-06-12 21:08:28');
