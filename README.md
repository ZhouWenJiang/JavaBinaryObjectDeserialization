# JavaBinaryObjectDeserialization
解析ObjectOutputStream序列化输出的二进制数据,  
项目代码从 https://github.com/thirdy/rejava 中抽取而来。

##使用实例
      byte[] bytes = null;// 通过java ObjectOutputStream输出的二进制数据
      Deserializer deserializer = new Deserializer();
      SerializedStream ss = deserializer.readSerialized(bytes);

##github中python版本
  https://github.com/tcalmant/python-javaobj

##相关内容
java序列化协议  
  http://www.ibm.com/developerworks/library/se-lookahead/  
  http://docs.oracle.com/javase/6/docs/platform/serialization/spec/protocol.html  
  http://blog.csdn.net/silentbalanceyh/article/details/8183849  
  http://blog.csdn.net/silentbalanceyh/article/details/8250096  
  http://blog.csdn.net/silentbalanceyh/article/details/8294269
