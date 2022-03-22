package cn.itcast.em.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zzj
 * @version 1.0
 * @date 2022/3/22
 */
@ConfigurationProperties(prefix = "eagle")
public class EagleMapProperties {

    private String host = "127.0.0.1";
    private int port = 8484;
    private int timeout = 10000;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EagleMapProperties{");
        sb.append("host='").append(host).append('\'');
        sb.append(", port=").append(port);
        sb.append(", timeout=").append(timeout);
        sb.append('}');
        return sb.toString();
    }
}
