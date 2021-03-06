/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.projecthosting;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Repository url.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = ProjectHostingNamespace.PROJECTS_ALIAS,
    nsUri = ProjectHostingNamespace.PROJECTS,
    localName = RepositoryUrl.XML_NAME)
public class RepositoryUrl extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "repositoryUrl";

  /**
   * Default mutable constructor.
   */
  public RepositoryUrl() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable value or <code>null</code> for a mutable value
   */
  public RepositoryUrl(String value) {
    super(ProjectHostingNamespace.PROJECTS_NS, XML_NAME, null, value);
    setRequired(false);
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(RepositoryUrl.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{RepositoryUrl value=" + getValue() + "}";
  }

}

