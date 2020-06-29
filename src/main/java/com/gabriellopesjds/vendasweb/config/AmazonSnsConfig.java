package com.gabriellopesjds.vendasweb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AmazonSnsConfig {

    @Autowired
    private AmazonSnsProperties properties;

    // 1 - Variáveis de ambiente{AWS_ACCESS_KEY_ID, AWS_SECRET_ACESS_KEY}
    // 2 - Propriedades do sistema{Java-aws.acessKeyId e aws.secretKey
    // 3 - Arquivo de  perfis de credencial padrão (~/.aws/cedentrials)
    // 4 - Credenciais do container da amazon ECS ( váriavel de ambiente )
    // 5 - Credenciais de perfil da instância (metadados da EC2)
    @Bean
    public AmazonSNS amazonSNS(){
        var credentials = new BasicAWSCredentials(properties.getAccessKey(),properties.getSecretAccessKey());

        return AmazonSNSClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(properties.getRegion())
            .build();
    }
}