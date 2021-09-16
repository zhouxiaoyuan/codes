# codes

在使用github客户端提交代码时，报错
failed to receive handshake ssl/tls connection failed
解决方法:
         git config --global http.sslBackend "openssl"
有时不好使

OpenSSL SSL_read: Connection was reset, errno 10054
解决方法:
git config --global http.sslVerify "false"


