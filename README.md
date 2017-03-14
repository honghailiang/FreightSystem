# FreightSystem
基于java Swing编写的运费计算系统

初始化数据

从excel中读取数据，转化为对象（只保存基础数据：序列号、始发站、目的站、省份、100kg以下（元/kg）、100kg以上（元/kg）、到货（元/kg）、自提（元/kg）、补贴里程、公路里程、单价（元/吨公里））并保存到map（key为“出发地-目的地城市-省份”，value为AirFreight对象）中 表名和sheet名都是在配置文件中配置的（mango.properties），行和列及特殊字段也是在配置文件中配置的目的地和省份存在cityProvinceList中











用swing绘制系统并执行业务逻辑

建立FreightSwing，并初始化数据从cityProvinceList中获取城市和省份目的地做成可检索的（清除输入框的内容后键盘输入拼音(全拼)或者汉字点击enter键）用JAutoCompleteComboBox实现，其中包括用pinyin4j实现的中文向拼音的转换及输入拼音或者汉字匹配检索功能根据选择目的地、输入卷烟数量、选择的配送方式进行运费的计算，从map中取出AirFreight中的基础数据进行计算，目前显示如下：









