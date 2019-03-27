/**  
 * @Title: CodeGeneration.java  
 * @Package com.example.demo  
 * @Description: TODO(用一句话描述该文件做什么)
 * <p>Copyright: Copyright (c) 2018<／p> 
 * <p>Company: GYZQ<／p> 
 * @author Ds  
 * @date 2019年3月27日  
 * @version V1.0  
 */  
package com.example.demo;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**  
 * @ClassName: CodeGeneration  
 * @Description: 数据库代码生成器
 * @author Ds  
 * @date 2019年3月27日  
 *    
 */
public class CodeGeneration {
	 /**
    *
    * @Title: main
    * @Description: 数据库代码生成器
    * @param args
    */
   public static void main(String[] args) {
       AutoGenerator mpg = new AutoGenerator();

       // 全局配置
       GlobalConfig gc = new GlobalConfig();
       gc.setOutputDir("H:\\YdzyWorkSpace\\ydzyms-admin\\src\\\\main\\java");//输出文件路径
       gc.setFileOverride(true);
       gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
       gc.setEnableCache(false);// XML 二级缓存
       gc.setBaseResultMap(false);// XML ResultMap
       gc.setBaseColumnList(false);// XML columList
       gc.setAuthor("DS");// 作者

       // 自定义文件命名，注意 %s 会自动填充表实体属性！
       gc.setControllerName("%sController");
       gc.setServiceName("%sService");
       gc.setServiceImplName("%sServiceImpl");
       gc.setMapperName("%sMapper");
//       gc.setXmlName("%sMapper");
       mpg.setGlobalConfig(gc);

       // 数据源配置
       DataSourceConfig dsc = new DataSourceConfig();
       dsc.setDbType(DbType.ORACLE);
       dsc.setDriverName("oracle.jdbc.OracleDriver");
       dsc.setUsername("ydzy_test");
       dsc.setPassword("guoyuan123");
       dsc.setUrl("jdbc:oracle:thin:@192.168.1.203:1521:gy001");
       mpg.setDataSource(dsc);

       // 策略配置
       StrategyConfig strategy = new StrategyConfig();
      // strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
       strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
       strategy.setInclude(new String[] { "YDZY_USER_ROLE" }); // 需要生成的表

       strategy.setSuperServiceClass(null);
       strategy.setSuperServiceImplClass(null);
       strategy.setSuperMapperClass(null);

       mpg.setStrategy(strategy);

       // 包配置
       PackageConfig pc = new PackageConfig();
       pc.setParent("com.guoyuan.modules.business");
       pc.setController("controller");
       pc.setService("service");
       pc.setServiceImpl("service.impl");
       pc.setMapper("dao");
       pc.setEntity("entity");
//       pc.setXml("xml");
       mpg.setPackageInfo(pc);

       // 执行生成
       mpg.execute();

   }
}
