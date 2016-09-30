/* Copyright (C) 2004-2007 Sami Koivu
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.zz.serialized;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.Deserializer;
import com.zz.util.ByteSerializer;


public class SerializedObject implements Content {

  private ClassDesc                 classDesc;
  private Map<ClassDesc, ClassData> superData = new HashMap<ClassDesc, ClassData>();
  private long                      identity;

  public void setClassDesc( ClassDesc classDesc ) {
    this.classDesc = classDesc;
  }

  public ClassDesc getClassDesc() {
    return this.classDesc;
  }

  public Map<ClassDesc, ClassData> getSuperClassData() {
    return this.superData;
  }

  public void setIdentityHashcode( long identity ) {
    this.identity = identity;
  }

  public long getIdentityHashcode() {
    return this.identity;
  }

  @Override
  public String toString() {
    return this.classDesc.getName() + "@" + this.identity;
  }

  public void serialize( ByteSerializer serializer, List<Object> handles ) {
    // TC_OBJECT classDesc newHandle classdata[]
    if(handles.contains(this)) {
      serializer.addByte(Deserializer.TC_REFERENCE);
      serializer.addInt(handles.indexOf(this) + Deserializer.baseWireHandle);
    }
    else {
      serializer.addByte(Deserializer.TC_OBJECT);
      this.classDesc.serialize(serializer, handles);
      handles.add(this);
      // TODO: super data serialization
      // this.data.serialize(serializer, handles);
    }
  }

  public void setClassData( ClassDesc sup, ClassData superData ) {
    this.superData.put(sup, superData);
  }

}
