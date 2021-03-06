/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.extensions;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Extension class for manipulating entries of the Contact kind.
 *
 * @deprecated Please use {@link com.google.gdata.data.contacts.ContactEntry}
 *     instead.
 * 
 */
@Kind.Term(ContactEntry.CONTACT_KIND)
@Deprecated
public class ContactEntry extends BaseEntry<ContactEntry> {

  /**
   * Kind term value for Contact category labels.
   */
  public static final String CONTACT_KIND = Namespaces.gPrefix + "contact";

  /**
   * Kind category used to label feeds or entries that have Contact
   * extension data.
   */
  public static final Category CONTACT_CATEGORY =
    new Category(Namespaces.gKind, CONTACT_KIND);


  /**
   * Constructs a new empty ContactEntry with the appropriate kind category
   * to indicate that it is a contact.
   */
  public ContactEntry() {
    super();
    getCategories().add(CONTACT_CATEGORY);
  }

  /**
   * Constructs a new ContactEntry by doing a shallow copy of data from an
   * existing BaseEntry intance.
   */
  public ContactEntry(BaseEntry<?> sourceEntry) {
    super(sourceEntry);
    getCategories().add(CONTACT_CATEGORY);
  }

  /**
   * Initializes an ExtensionProfile based upon the extensions expected
   * by an ContactEntry.
   */
  @Override
  public void declareExtensions(ExtensionProfile extProfile) {
    extProfile.declare(ContactEntry.class, Email.getDefaultDescription());
    extProfile.declare(ContactEntry.class,
        Im.getDefaultDescription(false, true));
    extProfile.declare(ContactEntry.class, PhoneNumber.getDefaultDescription());
    extProfile.declare(ContactEntry.class,
        PostalAddress.getDefaultDescription());
    extProfile.declare(ContactEntry.class,
        Organization.getDefaultDescription(false, false));
    extProfile.declare(ContactEntry.class, GeoPt.getDefaultDescription());
    extProfile.declare(ContactEntry.class, Deleted.class);
  }

  public List<Email> getEmailAddresses() {
    return getRepeatingExtension(Email.class);
  }

  public void addEmailAddress(Email email) {
    getEmailAddresses().add(email);
  }

  public List<Im> getImAddresses() {
    return getRepeatingExtension(Im.class);
  }

  public void addImAddress(Im im) {
    getImAddresses().add(im);
  }

  public List<PhoneNumber> getPhoneNumbers() {
    return getRepeatingExtension(PhoneNumber.class);
  }

  public void addPhoneNumber(PhoneNumber phoneNumber) {
    getPhoneNumbers().add(phoneNumber);
  }

  public List<PostalAddress> getPostalAddresses() {
    return getRepeatingExtension(PostalAddress.class);
  }

  public void addPostalAddress(PostalAddress postalAddress) {
    getPostalAddresses().add(postalAddress);
  }

  public Organization getOrganization() {
    return getExtension(Organization.class);
  }
  public void setOrganization(Organization org) {
    setExtension(org);
  }
  public List<GeoPt> getLocations() {
    return getRepeatingExtension(GeoPt.class);
  }

  public void addLocation(GeoPt geoPt) {
    getLocations().add(geoPt);
  }

  public void setDeleted() {
    addExtension(new Deleted());
    // Deleted entries cannot be edited further.
    setCanEdit(false);
  }

  public boolean isDeleted() {
    return getExtension(Deleted.class) != null;
  }
}
