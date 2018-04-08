package com.rs.lang;

import java.io.Serializable;

public final class NString implements Serializable, Comparable<NString>, CharSequence {

  private final char[] value;
  private int hash; // default to 0

  public NString() {
    value = new char[0];
  }

  public NString(NString original) {
    this.value = original.value;
    this.hash = original.hash;
  }

  public NString(char[] value) {
    this.value = new char[value.length];
    System.arraycopy(value, 0, this.value, 0, value.length);
  }

  public NString(char[] value, int offset, int count) {
    if (offset < 0) {
      throw new StringIndexOutOfBoundsException(offset);
    }
    if (count < 0) {
      throw new StringIndexOutOfBoundsException(count);
    }
    if (offset + count > value.length) {
      throw new StringIndexOutOfBoundsException(offset + count);
    }
    if (count == 0) {
      this.value = new char[0];
      return;
    }

    this.value = new char[count];
    System.arraycopy(value, offset, this.value, 0, count);
  }

  public NString(StringBuffer builder) {
    // TODO
    this.value = null;
  }

  public NString(StringBuilder builder) {
    // TODO
    this.value = null;
  }

  public boolean isEmpty() {
    return value.length == 0;
  }

  public char charAt(int index) {
    if (index < 0 || index >= value.length) {
      throw new StringIndexOutOfBoundsException(index);
    }
    return value[index];
  }

  public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
    if (srcBegin < 0) {
      throw new StringIndexOutOfBoundsException(srcBegin);
    }
    if (srcEnd > value.length) {
      throw new StringIndexOutOfBoundsException(srcEnd);
    }
    if (srcBegin > srcEnd) {
      throw new StringIndexOutOfBoundsException(srcBegin - srcEnd);
    }
    System.arraycopy(value, srcBegin, dst, dstBegin, srcEnd - srcBegin);
  }

  public boolean contentEquals(CharSequence cs) {
    // TODO
    return false;
  }

  public boolean equalsIgnoreCase(NString anotherString) {
    // TODO
    return false;
  }

  public int compareToIgnoreCase(NString str) {
    // TODO
    return 0;
  }

  public boolean regionMatches(int toffset, NString other, int ooffset, int len) {
    // TODO
    return false;
  }

  public boolean regionMatches(boolean ignoreCase, int toffset,
      NString other, int ooffset, int len) {
    // TODO
    return false;
  }

  public boolean startsWith(NString suffix, int toffset) {
    // TODO
    return false;
  }

  public boolean startsWith(NString suffix) {
    // TODO
    return false;
  }

  public boolean endsWith(NString suffix) {
    // TODO
    return false;
  }

  public int hashCode() {
    // TODO
    return 0;
  }

  public int indexOf(int ch) {
    // TODO
    return 0;
  }

  public int lastIndexOf(int ch) {
    // TODO
    return 0;
  }

  public int indexOf(NString str) {
    // TODO
    return 0;
  }

  public int indexOf(NString str, int fromIndex) {
    // TODO
    return 0;
  }

  public int lastIndexOf(NString str) {
    // TODO
    return 0;
  }

  public int lastIndexOf(NString str, int fromIndex) {
    // TODO
    return 0;
  }

  public NString substring(int beginIndex) {

    // TODO
    return null;
  }

  public NString substring(int beginIndex, int endIndex) {

    // TODO
    return null;
  }

  public NString concat(NString string) {

    // TODO
    return null;
  }

  public NString replace(char oldChar, char newChar) {
    // TODO
    return null;
  }

  public boolean matches(NString regex) {
    // TODO
    return false;
  }

  public boolean contains(CharSequence sequence) {
    // TODO
    return false;
  }

  public NString replaceFirst(CharSequence target, CharSequence replacement) {
    // TODO
    return null;
  }

  public NString replaceAll(CharSequence target, CharSequence replacement) {
    // TODO
    return null;
  }

  public NString replace(CharSequence target, CharSequence replacement) {
    // TODO
    return null;
  }

  public NString[] split(NString regex, int limit) {
    // TODO
    return null;
  }

  public NString[] split(NString regex) {
    // TODO
    return null;
  }

  public static NString join(CharSequence delimiter, CharSequence... elements) {
    // TODO
    return null;
  }

  public static NString join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
    // TODO
    return null;
  }

  public NString toLowerCash() {
    // TODO
    return null;
  }

  public NString toUpperCash() {
    // TODO
    return null;
  }

  public NString trim() {
    // TODO
    return null;
  }

  public char[] toCharArray() {
    // TODO
    return null;
  }

  public int length() {
    return value.length;
  }

  public CharSequence subSequence(int start, int end) {
    // TODO
    return null;
  }

  public int compareTo(NString o) {
    char[] v1 = value;
    char[] v2 = o.value;
    int len1 = v1.length;
    int len2 = v2.length;
    int lim = Math.min(len1, len2);

    for (int i = 0; i < lim; i++) {
      char c1 = v1[i];
      char c2 = v2[i];
      if (c1 != c2) {
        return c1 - c2;
      }
    }

    return len1 - len2;
  }

  @Override
  public boolean equals(Object anObject) {
    if (this == anObject) {
      return true;
    }
    if (anObject instanceof NString) {
      NString anotherString = (NString) anObject;
      int n = anotherString.value.length;
      if (n == value.length) {
        char[] v1 = value;
        char[] v2 = anotherString.value;
        int i = 0;
        while (n-- != 0) {
          if (v1[i] != v2[i]) {
            return false;
          }
          i++;
        }
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return new String(value);
  }
}
