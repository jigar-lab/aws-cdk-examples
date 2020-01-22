package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.codebuild.CfnSourceCredential;
import software.amazon.awscdk.services.codebuild.CfnSourceCredentialProps;

public class SourceCredentialStack extends Stack {

    public SourceCredentialStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public SourceCredentialStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        CfnSourceCredentialProps sourceCredentialProps = CfnSourceCredentialProps.builder()
                .authType("BASIC_AUTH")
                .serverType("BITBUCKET")
                .token("app_password")
                .username("app_username")
                .build();

        new CfnSourceCredential(this, id, sourceCredentialProps);
    }
}
