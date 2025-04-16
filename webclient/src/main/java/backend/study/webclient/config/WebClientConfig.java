package backend.study.webclient.config;

import static io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
    
    /**
     * WebClient Bean
     *
     * @return
     */
    @Bean
    public WebClient webClient() {

        HttpClient httpClient = HttpClient.create()
            .compress(true) //서버의 응답에 대해 압축 전송을 허용하는 설정 (Accept-Encoding 헤더 추가)
            .option(CONNECT_TIMEOUT_MILLIS, 5000) //연결 타임아웃 설정 (5초)
            .responseTimeout(Duration.ofSeconds(30)) //응답 타임아웃 설정 (30초)
            .doOnConnected(connection -> {
                connection
                    .addHandlerFirst(new ReadTimeoutHandler(30)) //읽기 타임아웃 설정 (30초)
                    .addHandlerLast(new WriteTimeoutHandler(30)) //쓰기 타임아웃 설정 (30초)
                ;
            });

        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();
    }

}
