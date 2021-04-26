package com.zyzh.commons.constant;

import com.yunkou.common.util.ResourceBundleUtil;
import com.yunkou.common.util.gson.JsonUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 系统常量类
 * @author-"zhaozhiyuan"
 * @date 2017年2月27日 上午10:34:27
 */
public class Constant {

	/** Json工具类 */
	public static JsonUtil jsonUtil = JsonUtil.getInstance(null, null);
	/** 资源文件工具类 */
	public static ResourceBundleUtil bundle = new ResourceBundleUtil(ResourceBundle.getBundle("system"));
	/** 线程池  */
	public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
	/** 系统登录用户的标志key */
	public static final String LOGIN_USER_KEY = "login_user_flag";
	/** 项目名称 */
	public static final String PROJECT_NAME = bundle.getString("PROJECT_NAME", "出入境风险拦截系统");
	public static final String SYSTEM_OWNER_VALUE = bundle.getString("SYSTEM_OWNER_VALUE", "CUS");
	public static String SYSTEM_OWNER = null;
	/** 系统部署单位 */
	public static class SystemOwnerString {
		public static final String CUS_CHINESE = "海关";
		public static final String CIQ_CHINESE = "国检";
		public static final String CUS_ENGLISH = "CUS";
		public static final String CIQ_ENGLISH = "CIQ";
	}
	/**是否需要与第三方系统接口对接 */
	public static final String NEED_THIRD_PARTY = bundle.getString("NEED_THIRD_PARTY");
	public static final String THIRD_PARTY_URL = bundle.getString("THIRD_PARTY_URL");
	public static final int NEED_SEND_AGAIN = bundle.getInt("NEED_SEND_AGAIN", 0);
	public static final int NEED_CONNECT_MQ = bundle.getInt("NEED_CONNECT_MQ", 0);
	public static final int ACTIVE_CONNECT_MQ = bundle.getInt("ACTIVE_CONNECT_MQ", 0);

	/** 拦截报警画面推送频道入境 */
	public static final String INTERCEPT_ALARM_CHANNEL_ENTRY = "entry";
	/** 拦截报警画面推送频道出境 */
	public static final String INTERCEPT_ALARM_CHANNEL_EXIT = "exit";
	/** 拦截报警画面推送频道中转 */
	public static final String INTERCEPT_ALARM_CHANNEL_TRANSFER = "transfer";
	/** 拦截报警画面推送频道 */
	public static final String INTERCEPT_ALARM_CHANNEL = "alarm";
	/** 辅助查验画面推送频道 */
	public static final String ASSIST_CHECK_CHANNEL = "assistcheck";
	/** 综合查验画面推送频道 */
	public static final String SUMMARY_CHECK_CHANNEL = "summarycheck";
	/** KVM资源文件工具类 */
	public static ResourceBundleUtil XRAY_KVM = new ResourceBundleUtil(ResourceBundle.getBundle("xraykvm"));
	/** KVM编号对应线体的KVM的IP */
	public static final Map<String, String> KVM_MAP = new HashMap<String, String>();

	/** 出境登机牌是否需要验证航班信息 */
	public static final int BOARDING_CHECK_FLIGHT = bundle.getInt("BOARDING_CHECK_FLIGHT", 0);
	/** 开始航班信息默认有效时间(h) */
	public static final int FLIGHT_VALID_TIME = bundle.getInt("FLIGHT_VALID_TIME", 0);
	/** 出境出发地 */
	public static final String DEFAULT_DEPARTURE = bundle.getString("DEFAULT_DEPARTURE", "");
	/** 出境登机牌有效期设置(h), 暂为提前安检24h，飞机晚点12h */
	public static final int BOARDING_CHECK_BEFORE = bundle.getInt("BOARDING_CHECK_BEFORE", 0);
	public static final int BOARDING_CHECK_LATE = bundle.getInt("BOARDING_CHECK_LATE", 0);
	/** 入境 行李布控标签有效期(h) */
	public static final int RFID_VALID_TIME = bundle.getInt("RFID_VALID_TIME", 0);
	/** 拦截报警页面当天显示报警条数 */
	public static final int WARN_SHOW_COUNT = bundle.getInt("WARN_SHOW_COUNT", 0);
	/** 闸机有效指令回复时间  */
	public static final long ORDER_VALID_TIME = bundle.getLong("ORDER_VALID_TIME", 2000L);

	/**集中判图Xpcc系统接口是否启动 */
	public static final int XPCC_CONNECT = bundle.getInt("XPCC_CONNECT", 0);
	/**集中判图Xpcc系统角色名称 */
	public static final String XPCC_ROLE_NAME = bundle.getString("XPCC_ROLE_NAME", "");
	/**集中判图Xpcc心跳时间间隔 */
	public static final long XPCC_HEARTBEAT_INTERVAL = bundle.getLong("XPCC_HEARTBEAT_INTERVAL", 3000L);
	/** 集中判图Xpcc心跳 */
	public static final String XPCC_HEARTBEAT_TIMEOUT = bundle.getString("XPCC_HEARTBEAT_TIMEOUT", "0");
	/** 集中判图Xpcc上报包裹X光照片 */
	public static final String XPCC_PACKAGE_XRAY_UPLOAD = bundle.getString("XPCC_PACKAGE_XRAY_UPLOAD", "");
	/** 集中判图Xpcc上报包裹可见光照片 */
	public static final String XPCC_PACKAGE_PHOTO_UPLOAD = bundle.getString("XPCC_PACKAGE_PHOTO_UPLOAD", "");
	/** 集中判图Xpcc上报包裹条码 */
	public static final String XPCC_PACKAGE_BARCODE_UPLOAD = bundle.getString("XPCC_PACKAGE_BARCODE_UPLOAD", "");


	/**Pad角色名称 */
	public static final String PAD_ROLE_NAME = bundle.getString("PAD_ROLE_NAME", "");

	/** LOG_HOME */
	public static final String LOG_HOME = bundle.getString("LOG_HOME");
	/** 图片存储路径 */
	public static final String IMAGEPATH = bundle.getString("IMAGEPATH", "D:");
	/** X光图片处理前存放路径 */
	public static final String NO_DEAL_DIRECTORY =  "/resources/files/xrayPhotos/nodeal/";
	/** 可见光图片存放路径 */
	public static final String CAMERA_DIRECTORY =  "/resources/files/photos/";
	/** 报警抓拍可见光图片存放路径 */
	public static final String ALARM_DIRECTORY =  "/resources/files/alarm/";
	/** 图片多张时，分号分割 */
	public static final String SEMICOLON = ";";
	/** 图片类型 (1：X光, 2：可见光) */
	public static final String IMAGE_TYPE_XRAY = "1";
	public static final String IMAGE_TYPE_PHOTO = "2";
	/** Excel文件临时存放路径 */
	public static final String EXPORT_TEMP_DIR = bundle.getString("EXPORT_TEMP_DIR");
	/** 百分比格式化数据 */
	public static final String FORMAT = "0.00%";

	/**报文名称与处理消息对象map */
	public static final Map<String, Object> MESSAGE_MAP = new HashMap<String, Object>();
	/**
	 * @Description: 消息处理相关的常量
	 */
	public static class MessageConstant {
		/**接收正常 */
		public static final String REVEIVE_STATUS_NORM = "01";
		/**接收异常 */
		public static final String REVEIVE_STATUS_UNNORM = "03";
		/**报文数据 */
		public static final String MESSAGE_TYPE_SEND = "01";
		/**数据回执 */
		public static final String MESSGE_TYPE_RECEIPT = "02";
		/**风险拦截系统标识 */
		public static final String SYSTEM_RISK = "IRIS";
		/**安检信息系统标识 */
		public static final String SYSTEM_SIMSA = "SIMSA";
		/**报文版本号 */
		public static final String MESSAGE_VERSION = "1.0";
		/**布控成功 */
		public static final String OPERATION_CONTROL_SUCCESS = "01";
		/**布控失败 */
		public static final String OPERATION_CONTROL_FAILURE = "03";
		/**撤销成功 */
		public static final String REVOKE_SUCCESS = "01";
		/**撤销失败 */
		public static final String REVOKE_FAILED = "03";
		/**拦截成功 */
		public static final String INTERCEPT_SUCCESS = "01";
		/**拦截失败 */
		public static final String INTERCEPT_FAILED = "03";
		/**需要与第三方系统对接 */
		public static final String NEED_THIRD_PARTY = "1";
		/**不需要与第三方系统对接 */
		public static final String NONEED_THIRD_PARTY = "0";
		/** IMF航班信息时间格式 */
		public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
	}

	/** 网络摄像头相关参数 */
	/** 设备端口号 */
	public  static final short CAMERA_PORT = (short) bundle.getInt("CAMERA_PORT", 8000);
	/** 登录的用户名 */
	public static final String CAMERA_NAME = bundle.getString("CAMERA_NAME", "admin");
	/** 用户密码 */
	public static final String CAMERA_PASSWORD = bundle.getString("CAMERA_PASSWORD", "zyzh1234");
	/** onvif协议拍照地址 */
	public static final String CAMERA_ONVIF_ADDRESS = bundle.getString("CAMERA_ONVIF_ADDRESS", "/onvif/snapshot/101");
	/** 通道摄像头图像配置获取接口 */
	public static final String CAMERA_IMAGE_CONFIG_GET = bundle.getString("CAMERA_IMAGE_CONFIG_GET", "/getCameraParameters");
	/** 通道摄像头图像配置设置接口 */
	public static final String CAMERA_IMAGE_CONFIG_SET = bundle.getString("CAMERA_IMAGE_CONFIG_SET", "/setCameraParameters");
	/** 通道摄像头图像配置保存接口 */
	public static final String CAMERA_IMAGE_CONFIG_SAVE = bundle.getString("CAMERA_IMAGE_CONFIG_SAVE", "/saveCameraConfig");
	/** 通道摄像头图像配置心跳 */
	public static final String CAMERA_HEARTBEAT = bundle.getString("CAMERA_HEARTBEAT", "/heartbeat");
	/** 标签格式前缀(LPID) 后缀(E) */
	public static String RFID_NO_FORRMORT1 = bundle.getString("RFID_NO_FORRMORT1", "");
	public static String RFID_NO_FORRMORT2 = bundle.getString("RFID_NO_FORRMORT2", "");
	/** 下载文件访问路径 */
	public static final String URL_DOWNLOAD = "/download/download";
	/** 监听服务是否处于运行状态的访问路径 */
	public static final String URL_HEARTBEAT = "/heartBeat/isAlive";
	public static final String HTTP_PREFIX = "http://";
	public static final String COLON = ":";

	/**
	 * @Description: 系统配置
	 */
	public static class SystemManageConstant {
		/** 参数配置对应的名称 */
		public static String SIMPLECONFIG_NAME = "simpleConfigVo";
		/** 第三方配置对应的名称 */
		public static String INTERFACECONFIG_NAME = "interfaceConfigVo";
		/** 通道配置对应的名称 */
		public static String DEVICECONFIG_NAME = "deviceConfig";
		/** 线体配置对应的名称 */
		public static String LINECONFIG_NAME = "lineConfig";
		/** 监控配置对应的名称 */
		public static String MONITORCONFIG_NAME = "monitorConfig";
	}

	/**
	 * @Description: 监控配置
	 */
	public static final class MonitorConstant {
		/** 监控扫描时间  */
		public static final long MONITOR_INTERVAL_TIME = bundle.getLong("MONITOR_INTERVAL_TIME");
	}

	/**
	 * @Description: 数据库删除操作
	 * @author-"zhaozhiyuan"
	 * @date 2017年2月27日 上午10:36:10
	 */
	public static class DatabaseConstant {
		/** 未删除:0  删除:1 */
		public static final int NO_DEL = 0;
		public static final int DEL = 1;
		/** 数据类型   出境:0   入境:1 */
		public static final String TYPE_EXIT = "0";
		public static final String TYPE_ENTRY = "1";
		/** 标识结果   无效:0   有效:1 */
		public static final String LABEL_INVALID = "0";
		public static final String LABEL_EFFECTIVE = "1";
		/** 风险等级   无风险:0   高危:1   低危：2 */
		public static final String RISK_NONE = "0";
		public static final String RISK_HIGH = "1";
		public static final String RISK_LOW = "2";
		/** 开拆状态   未拆:0   已拆:1 */
		public static final String OPEN_NO = "0";
		public static final String OPEN_YES = "1";
		/** 查验结果   未命中:0   命中:1 */
		public static final String CHECK_MISS = "0";
		public static final String CHECK_HIT = "1";
		/** 处置结果   放行:0   扣留:1 */
		public static final String HANDLE_RELEASE = "0";
		public static final String HANDLE_DETAIN = "1";
		/** 证件类型   风险旅客表证件类型 001-010 */
		public static final String CARD001 = "001";
		public static final String CARD002 = "002";
		public static final String CARD003 = "003";
		public static final String CARD004 = "004";
		public static final String CARD005 = "005";
		public static final String CARD006 = "006";
		public static final String CARD007 = "007";
		public static final String CARD008 = "008";
		public static final String CARD009 = "009";
		public static final String CARD010 = "010";
	}

	/**
	 * @Description: 数据操作结果
	 * @author-"zhaozhiyuan"
	 * @date 2017年2月27日 下午2:01:06
	 */
	public static class OperateResultConstant {
		/** 失败:-1  成功:0 */
		public static final int STATUS_FAILED = -1;
		public static final int STATUS_SUCCEEDED = 0;
		public static final String MSG_NoRequired = "缺少必填项";
		public static final String STATUS_NULL_MSG = "未查询到数据";
		public static final String STATUS_SUCCESS_MSG = "保存成功";
	}

	/**
	 * @Description: 拦截报警处理操作
	 * @author-"zhaozhiyuan"
	 * @date 2017年3月13日 下午2:03:28
	 */
	public static class HandleConstant {
		/** 布控 */
		public static final String CONTROLED = "1";
		/** 未布控 */
		public static final String NO_CONTROL = "0";
		/** 未拦截状态 */
		public static final String NOINTERCEPT_STATUS = "0";
		/** 已拦截状态 */
		public static final String INTERCEPT_STATUS = "1";
		/**拦截成功 */
		public static final String INTERCEPT_SUCCESS = "1";
		/**拦截失败 */
		public static final String INTERCEPT_FAILED = "2";
		/** 未处理 */
		public static final String NO_HANDLE = "0";
		/** 已处理 */
		public static final String HANDLE = "4";
		/** 已确认 */
		public static final String CONFIRM = "1";
		/** 已忽略 */
		public static final String IGNORE = "2";
		/** 自动忽略 */
		public static final String AUTO_HANDLE = "3";
		/** 未处理报警集合类别 */
		public static final String UNHANDLE_LIST = "unhandleList";
		/** 未处理报警单个对象类别 */
		public static final String UNHANDLE_SINGLE = "unhandleSingle";
	}

	/**
	 * @Description: 风险等级
	 * @author-"zhaozhiyuan"
	 * @date 2017年5月14日 下午1:07:50
	 */
	public static class RiskLevelConstant {
		public static final String RISK_LEVEL_NO = "0";
		public static final String RISK_LEVEL_HIGH = "1";
		public static final String RISK_LEVEL_HIGH_NAME = bundle.getString("RISK_HIGH_NAME", "高危风险");
		public static final String RISK_LEVEL_LOW = "2";
		public static final String RISK_LEVEL_LOW_NAME = bundle.getString("RISK_LOW_NAME", "一般风险");
	}

	/**
	 * @Description: 闸机通道类别
	 * @author-"zhaozhiyuan"
	 * @date 2017年7月31日 下午1:11:39
	 */
	public static class PassengerWayType {
		/** 申报通道对应值*/
		public static final String PASSENGERWAY_TYPE_DECLARE_VALUE = "0";
		/** 申报通道名称*/
		public static final String PASSENGERWAY_TYPE_DECLARE_NAME = "申报通道";
		/** 非申报通道对应值 */
		public static final String PASSENGERWAY_TYPE_NODECLARE_VALUE = "1";
		/** 非申报通道名称 */
		public static final String PASSENGERWAY_TYPE_NODECLARE_NAME = "非申报通道";

	}

	/**
	 * @Description: 拦截报警返回类型对应的值
	 * @author-"zhaozhiyuan"
	 * @date 2017年2月28日 上午9:48:43
	 */
	public static class AlarmTypeValueConstant {
		/** 放行 */
		public static final String RELEASE_VALUE = "0";
		/** 旅客报警 */
		public static final String PASSENGER_ALARM_VALUE = "1";
		/** 行李报警 */
		public static final String BAGGAGE_ALARM_VALUE = "2";
		/** 旅客行李报警 */
		public static final String BOTH_ALARM_VALUE = "3";
		/** 登机牌格式非法 */
		public static final String IILLEGAL_TYPE_VALUE = "4";
		/** 报警返回时的key的名称 */
		public static final String ALARM_TYPE_NAME = "alarmType";
	}

	/**
	 * @Description: 统计分析查询
	 * @author-"zhaozhiyuan"
	 * @date 2017年5月3日 下午4:33:56
	 */
	public static class StatisticalConstant {
		public static final String YEAR = "年";
		public static final String YEAR_VALUE = "4";
		public static final String MONTH = "月";
		public static final String MONTH_VALUE= "2";
		public static final String QUARTER = "季度";
		public static final String QUARTER_VALUE = "3";
		public static final String DAY = "天";
		public static final String DAY_VALUE = "1";
	}

	/**
	 * @Description: 出入境常量值
	 * @author-"zhaozhiyuan"
	 * @date 2017年4月28日 上午11:21:22
	 */
	public static class EntryAndExitType {
		/** 出境值 */
		public static final String EXIT_TYPE_VALUE = "0";
		/** 出境名称 */
		public static final String EXIT_TYPE_NAME = "出境";
		/** 出境通道区域名称 */
		public static final String EXIT_REGION = "出境查验通道";
		/** 入境值 */
		public static final String ENTRY_TYPE_VALUE = "1";
		/** 入境名称 */
		public static final String ENTRY_TYPE_NAME = "入境";
		/** 入境通道区域名称 */
		public static final String ENTRY_REGION = "入境查验通道";
		public static final String TRANSFER_TYPE_VALUE = "2";
		public static final String TRANSFER_TYPE_NAME = "中转";
		public static final String TRANSFER_REGION = "中转查验通道";
		/** 航班类型，A:入港；D:离港 */
		public static final String FLIGHT_TYPE_ENTRY = "A";
		public static final String FLIGHT_TYPE_EXIT = "D";
	}

	/** 集中判图查验结果中需要拦截的结果 （1：放行；2：报警；3：复检；4：超时） */
	public static final String NEED_INTERCEPT_RESULT = bundle.getString("NEED_INTERCEPT_RESULT", "234");
	/** 集中判图查验结果 （1：放行；2：报警；3：复检；4：超时） */
	public static class CheckResult {
		public static final String PASS = "1";
		public static final String ALARM = "2";
		public static final String RECHECK = "3";
		public static final String TIMEOUT = "4";
	}

	/** 布控对象报警--行人 */
	public static final String CONTROL_OBJECT_PASSENGER = "行人";
	/** 布控对应行人对应值  */
	public static final String CONTROL_OBJECT_PASSENGER_VALUE = "02";
	/** 布控对象报警--行李 */
	public static final String CONTROL_OBJECT_BAGGAGE = "行李";
	/**布控对象行李对应值 */
	public static final String CONTROL_OBJECT_BAGGAGE_VALUE = "01";
	/**布控类型--预布控 */
	public static final String CONTROL_TYPE_PRE = "02";
	/**操作类型--布控 */
	public static final String OPERATION_TYPE_CONTROL = "01";
	/**操作类型--撤销布控 */
	public static final String OPERATION_TYPE_REVOKECONTROL = "03";
	/**永久布控 */
	public static final String CONTROL_PERIOD_PERMANENT = "0";
	/**长期布控 */
	public static final String CONTROL_PERIOD_LONG = "1";

	//TODO
	public static final String NEGATIVE_ONE = "-1";
	public static final String ONE = "1";
	public static final String ZERO = "0";
	public static final String TWO = "2";

	/** The Unix separator character. */
	public static final char UNIX_SEPARATOR = '/';
	/**xml后缀 */
	public static final String SUFFIX_XML = ".XML";
	/**jpg后缀 */
	public static final String SUFFIX_JPG = ".jpg";
	/** Excel后缀名 */
	public static final String SUFFIX_XLS = "xls";
}
