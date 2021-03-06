/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package net.consensys.cava.config;

import javax.annotation.Nullable;

/**
 * An exception thrown when an invalid type is encountered.
 */
public final class InvalidConfigurationPropertyTypeException extends RuntimeException {

  @Nullable
  private final DocumentPosition position;

  InvalidConfigurationPropertyTypeException(@Nullable DocumentPosition position, String message) {
    super(message);
    this.position = position;
  }

  InvalidConfigurationPropertyTypeException(
      @Nullable DocumentPosition position,
      String message,
      @Nullable Throwable cause) {
    super(message, cause);
    this.position = position;
  }

  /**
   * @return The position of the property in the configuration document, or {@code null} if there is no position
   *         available.
   */
  @Nullable
  public DocumentPosition position() {
    return position;
  }

  @Override
  public String toString() {
    if (position == null) {
      return getMessage();
    }
    return getMessage() + " (" + position + ")";
  }
}
