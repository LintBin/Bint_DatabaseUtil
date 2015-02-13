# Bint_DatabaseUtil
数据库工具：根据指定的数据库来生成表的相应的JavaBean



使用说明：请在dbconfig.xml中修改自己数据库所对应的相关数据，执行Main.java文件。生成的java文件在javabean文件夹里面。


补充：
1、支持自定义数据库字段类型和生成java类的域的对应关系，例如：oracle中的Blob类型，可自定义为为java的Blob类，也可以对应byte[]。
详细可在src/type.properties中进行修改

2、暂仅支持Oracle，MySQL
