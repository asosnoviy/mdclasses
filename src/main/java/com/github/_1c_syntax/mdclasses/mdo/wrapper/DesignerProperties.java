/*
 * This file is a part of MDClasses.
 *
 * Copyright © 2019 - 2020
 * Tymko Oleg <olegtymko@yandex.ru>, Maximov Valery <maximovvalery@gmail.com> and contributors
 *
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * MDClasses is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * MDClasses is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with MDClasses.
 */
package com.github._1c_syntax.mdclasses.mdo.wrapper;

import com.github._1c_syntax.mdclasses.metadata.additional.CompatibilityMode;
import com.github._1c_syntax.mdclasses.metadata.additional.ReturnValueReuse;
import com.github._1c_syntax.mdclasses.metadata.additional.ScriptVariant;
import com.github._1c_syntax.mdclasses.metadata.additional.UseMode;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Враппер над свойствами объекта в формате конфигуратора
 */
@Data
@NoArgsConstructor
public class DesignerProperties {

  @NonNull
  @XStreamAlias("Name")
  private String name;
  @NonNull
  @XStreamAlias("Comment")
  private String comment = "";

  @XStreamAlias("Server")
  private boolean server;
  @XStreamAlias("Global")
  private boolean global;
  @XStreamAlias("ClientManagedApplication")
  private boolean clientManagedApplication;
  @XStreamAlias("ExternalConnection")
  private boolean externalConnection;
  @XStreamAlias("ClientOrdinaryApplication")
  private boolean clientOrdinaryApplication;
  @XStreamAlias("ServerCall")
  private boolean serverCall;
  @XStreamAlias("Privileged")
  private boolean privileged;
  @NonNull
  @XStreamAlias("ReturnValuesReuse")
  private ReturnValueReuse returnValuesReuse = ReturnValueReuse.DONT_USE;

  @NonNull
  @XStreamAlias("Handler")
  private String handler = "";

  @NonNull
  @XStreamAlias("Content")
  private DesignerXRItems content = new DesignerXRItems();

  @NonNull
  @XStreamAlias("ScriptVariant")
  private ScriptVariant scriptVariant = ScriptVariant.ENGLISH;
  @NonNull
  @XStreamAlias("CompatibilityMode")
  private CompatibilityMode compatibilityMode = new CompatibilityMode();
  @NonNull
  @XStreamAlias("ConfigurationExtensionCompatibilityMode")
  private CompatibilityMode configurationExtensionCompatibilityMode = new CompatibilityMode();
  @NonNull
  @XStreamAlias("ModalityUseMode")
  private UseMode modalityUseMode = UseMode.USE;
  @NonNull
  @XStreamAlias("SynchronousExtensionAndAddInCallUseMode")
  private UseMode synchronousExtensionAndAddInCallUseMode = UseMode.USE;
  @NonNull
  @XStreamAlias("SynchronousPlatformExtensionAndAddInCallUseMode")
  private UseMode synchronousPlatformExtensionAndAddInCallUseMode = UseMode.USE;
  @NonNull
  @XStreamAlias("DefaultRunMode")
  private String defaultRunMode = "";
  @NonNull
  @XStreamAlias("DefaultLanguage")
  private String defaultLanguage = "";
  @NonNull
  @XStreamAlias("DataLockControlMode")
  private String dataLockControlMode = "";
  @NonNull
  @XStreamAlias("ObjectAutonumerationMode")
  private String objectAutonumerationMode = "";

}
