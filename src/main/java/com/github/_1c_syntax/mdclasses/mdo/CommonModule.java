package com.github._1c_syntax.mdclasses.mdo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github._1c_syntax.mdclasses.metadata.additional.ReturnValueReuse;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.Map;

import static com.github._1c_syntax.mdclasses.utils.MapExtension.getOrEmptyString;
import static com.github._1c_syntax.mdclasses.utils.MapExtension.getOrFalse;

@Value
@EqualsAndHashCode(callSuper = true)
@JsonDeserialize(builder = CommonModule.CommonModuleBuilderImpl.class)
@SuperBuilder
public class CommonModule extends MDObjectBase {

  protected boolean server;
  protected boolean global;
  protected boolean clientManagedApplication;
  protected boolean externalConnection;
  protected boolean clientOrdinaryApplication;
  protected boolean serverCall;
  @Builder.Default
  protected ReturnValueReuse returnValuesReuse = ReturnValueReuse.DONT_USE;
  protected boolean privileged;

  @JsonPOJOBuilder(withPrefix = "")
  @JsonIgnoreProperties(ignoreUnknown = true)
  static final class CommonModuleBuilderImpl extends CommonModule.CommonModuleBuilder<CommonModule, CommonModule.CommonModuleBuilderImpl> {

    @JsonProperty("Properties")
    @Override
    public CommonModule.CommonModuleBuilderImpl properties(Map<String, Object> properties) {
      super.properties(properties);

      server(getOrFalse(properties, "Server"));
      global(getOrFalse(properties, "Global"));
      clientManagedApplication(getOrFalse(properties, "ClientManagedApplication"));
      externalConnection(getOrFalse(properties, "ExternalConnection"));
      clientOrdinaryApplication(getOrFalse(properties, "ClientOrdinaryApplication"));
      serverCall(getOrFalse(properties, "ServerCall"));
      returnValuesReuse(ReturnValueReuse.fromValue(getOrEmptyString(properties, "ReturnValuesReuse")));
      privileged(getOrFalse(properties, "Privileged"));

      return this.self();
    }
  }
}
