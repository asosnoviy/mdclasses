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

import com.github._1c_syntax.mdclasses.mdo.MDObjectBase;
import com.github._1c_syntax.mdclasses.metadata.additional.MDOType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Класс-обертка для чтения xml описания объектов в формате конфигуратора
 */
@Data
@Slf4j
public class DesignerWrapper {

  @XStreamAlias("AccountingRegister")
  protected DesignerMDO accountingRegister;
  @XStreamAlias("AccumulationRegister")
  protected DesignerMDO accumulationRegister;
  @XStreamAlias("BusinessProcess")
  protected DesignerMDO businessProcess;
  @XStreamAlias("CalculationRegister")
  protected DesignerMDO calculationRegister;
  @XStreamAlias("Catalog")
  protected DesignerMDO catalog;
  @XStreamAlias("ChartOfAccounts")
  protected DesignerMDO chartOfAccounts;
  @XStreamAlias("ChartOfCalculationTypes")
  protected DesignerMDO chartOfCalculationTypes;
  @XStreamAlias("ChartOfCharacteristicTypes")
  protected DesignerMDO chartOfCharacteristicTypes;
  @XStreamAlias("CommandGroup")
  protected DesignerMDO commandGroup;
  @XStreamAlias("CommonAttribute")
  protected DesignerMDO commonAttribute;
  @XStreamAlias("CommonCommand")
  protected DesignerMDO commonCommand;
  @XStreamAlias("CommonForm")
  protected DesignerMDO commonForm;
  @XStreamAlias("CommonModule")
  protected DesignerMDO commonModule;
  @XStreamAlias("CommonPicture")
  protected DesignerMDO commonPicture;
  @XStreamAlias("CommonTemplate")
  protected DesignerMDO commonTemplate;
  @XStreamAlias("Configuration")
  protected DesignerMDO configuration;
  @XStreamAlias("Constant")
  protected DesignerMDO constant;
  @XStreamAlias("Cube")
  protected DesignerMDO cube;
  @XStreamAlias("DataProcessor")
  protected DesignerMDO dataProcessor;
  @XStreamAlias("DefinedType")
  protected DesignerMDO definedType;
  @XStreamAlias("DimensionTable")
  protected DesignerMDO dimensionTable;
  @XStreamAlias("Document")
  protected DesignerMDO document;
  @XStreamAlias("DocumentJournal")
  protected DesignerMDO documentJournal;
  @XStreamAlias("DocumentNumerator")
  protected DesignerMDO documentNumerator;
  @XStreamAlias("Enum")
  protected DesignerMDO _enum;
  @XStreamAlias("EventSubscription")
  protected DesignerMDO eventSubscription;
  @XStreamAlias("ExchangePlan")
  protected DesignerMDO exchangePlan;
  @XStreamAlias("ExternalDataProcessor")
  protected DesignerMDO externalDataProcessor;
  @XStreamAlias("ExternalDataSource")
  protected DesignerMDO externalDataSource;
  @XStreamAlias("ExternalReport")
  protected DesignerMDO externalReport;
  @XStreamAlias("FilterCriterion")
  protected DesignerMDO filterCriterion;
  @XStreamAlias("Form")
  protected DesignerMDO form;
  @XStreamAlias("FunctionalOption")
  protected DesignerMDO functionalOption;
  @XStreamAlias("FunctionalOptionsParameter")
  protected DesignerMDO functionalOptionsParameter;
  @XStreamAlias("HTTPService")
  protected DesignerMDO httpService;
  @XStreamAlias("InformationRegister")
  protected DesignerMDO informationRegister;
  @XStreamAlias("Interface")
  protected DesignerMDO _interface;
  @XStreamAlias("Language")
  protected DesignerMDO language;
  @XStreamAlias("Recalculation")
  protected DesignerMDO recalculation;
  @XStreamAlias("Report")
  protected DesignerMDO report;
  @XStreamAlias("Role")
  protected DesignerMDO role;
  @XStreamAlias("ScheduledJob")
  protected DesignerMDO scheduledJob;
  @XStreamAlias("Sequence")
  protected DesignerMDO sequence;
  @XStreamAlias("SessionParameter")
  protected DesignerMDO sessionParameter;
  @XStreamAlias("SettingsStorage")
  protected DesignerMDO settingsStorage;
  @XStreamAlias("Style")
  protected DesignerMDO style;
  @XStreamAlias("StyleItem")
  protected DesignerMDO styleItem;
  @XStreamAlias("Subsystem")
  protected DesignerMDO subsystem;
  @XStreamAlias("Table")
  protected DesignerMDO table;
  @XStreamAlias("Task")
  protected DesignerMDO task;
  @XStreamAlias("Template")
  protected DesignerMDO template;
  @XStreamAlias("WSReference")
  protected DesignerMDO wsReference;
  @XStreamAlias("WebService")
  protected DesignerMDO webService;
  @XStreamAlias("XDTOPackage")
  protected DesignerMDO xdtoPackage;

  /**
   * @param type - Тип читаемого объекта, по нему определяется имя свойства
   * @return - Возвращает MDObjectBase объект
   */
  public Optional<MDObjectBase> getPropertyByType(MDOType type, Path mdoPath) {
    var value = getPropertyValue(type);
    if (value.isPresent()) {
      try {
        Class<?> clazz = Class.forName(MDObjectBase.class.getPackageName()
          + "." + type.getMDOClassName());
        var designerMDO = value.get();
        designerMDO.setMdoPath(mdoPath);
        return Optional.of((MDObjectBase) clazz.getConstructor(DesignerMDO.class)
          .newInstance(designerMDO));
      } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
        | InstantiationException | InvocationTargetException e) {
        LOGGER.error("Can't read property for name", e);
      }
    }
    return Optional.empty();
  }

  private Optional<DesignerMDO> getPropertyValue(MDOType type) {
    switch (type) {
      case CONFIGURATION:
        return Optional.of(getConfiguration());
      case ENUM:
        return Optional.of(get_enum());
      case INTERFACE:
        return Optional.of(get_interface());
      case HTTP_SERVICE:
        return Optional.of(getHttpService());
      case WEB_SERVICE:
        return Optional.of(getWebService());
      case WS_REFERENCE:
        return Optional.of(getWsReference());
      case XDTO_PACKAGE:
        return Optional.of(getXdtoPackage());
      default:
        try {
          String propertyName = type.getName();
          return Optional.of((DesignerMDO) getClass()
            .getDeclaredField(
              propertyName.substring(0, 1).toLowerCase() + propertyName.substring(1))
            .get(this));
        } catch (IllegalAccessException | NoSuchFieldException e) {
          LOGGER.error("Can't find property for name", e);
        }

        return Optional.empty();
    }
  }
}