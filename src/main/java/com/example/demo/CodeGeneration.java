/**  
 * @Title: CodeGeneration.java  
 * @Package com.example.demo  
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * <p>Copyright: Copyright (c) 2018<��p> 
 * <p>Company: GYZQ<��p> 
 * @author Ds  
 * @date 2019��3��27��  
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
 * @Description: ���ݿ����������
 * @author Ds  
 * @date 2019��3��27��  
 *    
 */
public class CodeGeneration {
	 /**
    *
    * @Title: main
    * @Description: ���ݿ����������
    * @param args
    */
   public static void main(String[] args) {
       AutoGenerator mpg = new AutoGenerator();

       // ȫ������
       GlobalConfig gc = new GlobalConfig();
       gc.setOutputDir("H:\\YdzyWorkSpace\\ydzyms-admin\\src\\\\main\\java");//����ļ�·��
       gc.setFileOverride(true);
       gc.setActiveRecord(false);// ����ҪActiveRecord���Ե����Ϊfalse
       gc.setEnableCache(false);// XML ��������
       gc.setBaseResultMap(false);// XML ResultMap
       gc.setBaseColumnList(false);// XML columList
       gc.setAuthor("DS");// ����

       // �Զ����ļ�������ע�� %s ���Զ�����ʵ�����ԣ�
       gc.setControllerName("%sController");
       gc.setServiceName("%sService");
       gc.setServiceImplName("%sServiceImpl");
       gc.setMapperName("%sMapper");
//       gc.setXmlName("%sMapper");
       mpg.setGlobalConfig(gc);

       // ����Դ����
       DataSourceConfig dsc = new DataSourceConfig();
       dsc.setDbType(DbType.ORACLE);
       dsc.setDriverName("oracle.jdbc.OracleDriver");
       dsc.setUsername("ydzy_test");
       dsc.setPassword("guoyuan123");
       dsc.setUrl("jdbc:oracle:thin:@192.168.1.203:1521:gy001");
       mpg.setDataSource(dsc);

       // ��������
       StrategyConfig strategy = new StrategyConfig();
      // strategy.setTablePrefix(new String[] { "sys_" });// �˴������޸�Ϊ���ı�ǰ׺
       strategy.setNaming(NamingStrategy.underline_to_camel);// �������ɲ���
       strategy.setInclude(new String[] { "YDZY_USER_ROLE" }); // ��Ҫ���ɵı�

       strategy.setSuperServiceClass(null);
       strategy.setSuperServiceImplClass(null);
       strategy.setSuperMapperClass(null);

       mpg.setStrategy(strategy);

       // ������
       PackageConfig pc = new PackageConfig();
       pc.setParent("com.guoyuan.modules.business");
       pc.setController("controller");
       pc.setService("service");
       pc.setServiceImpl("service.impl");
       pc.setMapper("dao");
       pc.setEntity("entity");
//       pc.setXml("xml");
       mpg.setPackageInfo(pc);

       // ִ������
       mpg.execute();

   }
}
