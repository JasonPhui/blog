package cn.ph.blog.core.constant;

/**
 * 系统常用变量
 */
public class ProjectConstant {

    //项目基础包名称
    public static String BASE_PACKAGE = "cn.ph.blog";

    // Model所在包
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model";

    // Mapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";

    // 使用主数据源
    public static final String MAPPER_PACKAGE_DB1 = MAPPER_PACKAGE + ".db1";

    // 使用从数据源
    public static final String MAPPER_PACKAGE_DB2 = MAPPER_PACKAGE + ".db2";

    // Service所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";

    // ServiceImpl所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    // Controller所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";

    // Mapper插件基础接口的完全限定名
    public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.universal.Mapper";

    //文件上传储存的地址
    public static final String SAVEFILEPATH = "F://img";
}
