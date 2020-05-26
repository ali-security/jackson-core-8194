package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharacterEscapes;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonGeneratorDelegate extends JsonGenerator
{
    /**
     * Delegate object that method calls are delegated to.
     */
    protected JsonGenerator delegate;

    /**
     * Whether copy methods
     * ({@link #copyCurrentEvent}, {@link #copyCurrentStructure}, {@link #writeTree} and {@link #writeObject})
     * are to be called (true), or handled by this object (false).
     */
    protected boolean delegateCopyMethods;

    /*
    /**********************************************************************
    /* Construction, initialization
    /**********************************************************************
     */

    public JsonGeneratorDelegate(JsonGenerator d) {
        this(d, true);
    }

    /**
     * @param delegateCopyMethods Flag assigned to <code>delagateCopyMethod</code>
     *   and which defines whether copy methods are handled locally (false), or
     *   delegated to configured 
     */
    public JsonGeneratorDelegate(JsonGenerator d, boolean delegateCopyMethods) {
        delegate = d;
        this.delegateCopyMethods = delegateCopyMethods;
    }

    @Override
    public Object getCurrentValue() {
        return delegate.getCurrentValue();
    }

    @Override
    public void setCurrentValue(Object v) {
        delegate.setCurrentValue(v);
    }

    /*
    /**********************************************************************
    /* Public API, metadata
    /**********************************************************************
     */

    @Override public FormatSchema getSchema() { return delegate.getSchema(); }
    @Override public Version version() { return delegate.version(); }
    @Override public Object getOutputTarget() { return delegate.getOutputTarget(); }
    @Override public int getOutputBuffered() { return delegate.getOutputBuffered(); }

    /*
    /**********************************************************************
    /* Public API, capability introspection
    /**********************************************************************
     */

    @Override
    public boolean canWriteTypeId() { return delegate.canWriteTypeId(); }

    @Override
    public boolean canWriteObjectId() { return delegate.canWriteObjectId(); }

    @Override
    public boolean canWriteBinaryNatively() { return delegate.canWriteBinaryNatively(); }
    
    @Override
    public boolean canOmitFields() { return delegate.canOmitFields(); }

    @Override
    public boolean canWriteFormattedNumbers() { return delegate.canWriteFormattedNumbers(); }

    /*
    /**********************************************************************
    /* Public API, configuration
    /**********************************************************************
     */

    @Override
    public boolean isEnabled(StreamWriteFeature f) { return delegate.isEnabled(f); }

    @Override
    public int streamWriteFeatures() { return delegate.streamWriteFeatures(); }

    @Override
    public JsonGenerator configure(StreamWriteFeature f, boolean state) {
        delegate.configure(f, state);
        return this;
    }

    /*
    /**********************************************************************
    /* Configuring generator
    /**********************************************************************
      */

    @Override
    public JsonGenerator setHighestNonEscapedChar(int charCode) {
        delegate.setHighestNonEscapedChar(charCode);
        return this;
    }

    @Override
    public int getHighestNonEscapedChar() { return delegate.getHighestNonEscapedChar(); }

    @Override
    public CharacterEscapes getCharacterEscapes() {  return delegate.getCharacterEscapes(); }

    /*
    /**********************************************************************
    /* Public API, write methods, structural
    /**********************************************************************
     */

    @Override
    public void writeStartArray() throws IOException { delegate.writeStartArray(); }

    @Override
    public void writeStartArray(Object forValue) throws IOException { delegate.writeStartArray(forValue); }

    @Override
    public void writeStartArray(Object forValue, int size) throws IOException { delegate.writeStartArray(forValue, size); }

    @Override
    public void writeEndArray() throws IOException { delegate.writeEndArray(); }

    @Override
    public void writeStartObject() throws IOException { delegate.writeStartObject(); }

    @Override
    public void writeStartObject(Object forValue) throws IOException { delegate.writeStartObject(forValue); }

    @Override
    public void writeStartObject(Object forValue, int size) throws IOException {
        delegate.writeStartObject(forValue, size);
    }

    @Override
    public void writeEndObject() throws IOException { delegate.writeEndObject(); }

    @Override
    public void writeFieldName(String name) throws IOException {
        delegate.writeFieldName(name);
    }

    @Override
    public void writeFieldName(SerializableString name) throws IOException {
        delegate.writeFieldName(name);
    }

    @Override
    public void writeFieldId(long id) throws IOException {
        delegate.writeFieldId(id);
    }

    @Override
    public void writeArray(int[] array, int offset, int length) throws IOException {
        delegate.writeArray(array, offset, length);
    }

    @Override
    public void writeArray(long[] array, int offset, int length) throws IOException {
        delegate.writeArray(array, offset, length);
    }

    @Override
    public void writeArray(double[] array, int offset, int length) throws IOException {
        delegate.writeArray(array, offset, length);
    }

    @Override
    public void writeArray(String[] array, int offset, int length) throws IOException {
        delegate.writeArray(array, offset, length);
    }

    /*
    /**********************************************************************
    /* Public API, write methods, text/String values
    /**********************************************************************
     */

    @Override
    public void writeString(String text) throws IOException { delegate.writeString(text); }

    @Override
    public void writeString(Reader reader, int len) throws IOException {
        delegate.writeString(reader, len);
    }

    @Override
    public void writeString(char[] text, int offset, int len) throws IOException { delegate.writeString(text, offset, len); }

    @Override
    public void writeString(SerializableString text) throws IOException { delegate.writeString(text); }

    @Override
    public void writeRawUTF8String(byte[] text, int offset, int length) throws IOException { delegate.writeRawUTF8String(text, offset, length); }

    @Override
    public void writeUTF8String(byte[] text, int offset, int length) throws IOException { delegate.writeUTF8String(text, offset, length); }

    /*
    /**********************************************************************
    /* Public API, write methods, binary/raw content
    /**********************************************************************
     */

    @Override
    public void writeRaw(String text) throws IOException { delegate.writeRaw(text); }

    @Override
    public void writeRaw(String text, int offset, int len) throws IOException { delegate.writeRaw(text, offset, len); }

    @Override
    public void writeRaw(SerializableString raw) throws IOException { delegate.writeRaw(raw); }
    
    @Override
    public void writeRaw(char[] text, int offset, int len) throws IOException { delegate.writeRaw(text, offset, len); }

    @Override
    public void writeRaw(char c) throws IOException { delegate.writeRaw(c); }

    @Override
    public void writeRawValue(String text) throws IOException { delegate.writeRawValue(text); }

    @Override
    public void writeRawValue(String text, int offset, int len) throws IOException { delegate.writeRawValue(text, offset, len); }

    @Override
    public void writeRawValue(char[] text, int offset, int len) throws IOException { delegate.writeRawValue(text, offset, len); }

    @Override
    public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len) throws IOException { delegate.writeBinary(b64variant, data, offset, len); }

    @Override
    public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength) throws IOException { return delegate.writeBinary(b64variant, data, dataLength); }

    /*
    /**********************************************************************
    /* Public API, write methods, other value types
    /**********************************************************************
     */

    @Override
    public void writeNumber(short v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(int v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(long v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(BigInteger v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(double v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(float v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(BigDecimal v) throws IOException { delegate.writeNumber(v); }

    @Override
    public void writeNumber(String encodedValue) throws IOException, UnsupportedOperationException { delegate.writeNumber(encodedValue); }

    @Override
    public void writeNumber(char[] encodedValueBuffer, int offset, int length) throws IOException, UnsupportedOperationException { delegate.writeNumber(encodedValueBuffer, offset, length); }

    @Override
    public void writeBoolean(boolean state) throws IOException { delegate.writeBoolean(state); }
    
    @Override
    public void writeNull() throws IOException { delegate.writeNull(); }

    /*
    /**********************************************************************
    /* Public API, convenience field-write methods
    /**********************************************************************
     */

    // 04-Oct-2019, tatu: Reminder: these should NOT be delegated, unless matching
    //    methods in `FilteringGeneratorDelegate` are re-defined to "split" calls again

//    public void writeBinaryField(String fieldName, byte[] data) throws IOException {
//    public void writeBooleanField(String fieldName, boolean value) throws IOException {
//    public void writeNullField(String fieldName) throws IOException {
//    public void writeStringField(String fieldName, String value) throws IOException {
//    public void writeNumberField(String fieldName, short value) throws IOException {

//    public void writeArrayFieldStart(String fieldName) throws IOException {
//    public void writeObjectFieldStart(String fieldName) throws IOException {
//    public void writeObjectField(String fieldName, Object pojo) throws IOException {

    // Sole exception being this method as it is not a "combo" method
    
    @Override
    public void writeOmittedField(String fieldName) throws IOException {
        delegate.writeOmittedField(fieldName);
    }

    /*
    /**********************************************************************
    /* Public API, write methods, Native Ids
    /**********************************************************************
     */

    @Override
    public void writeObjectId(Object id) throws IOException { delegate.writeObjectId(id); }

    @Override
    public void writeObjectRef(Object id) throws IOException { delegate.writeObjectRef(id); }

    @Override
    public void writeTypeId(Object id) throws IOException { delegate.writeTypeId(id); }

    @Override
    public void writeEmbeddedObject(Object object) throws IOException { delegate.writeEmbeddedObject(object); }

    /*
    /**********************************************************************
    /* Public API, write methods, serializing Java objects
    /**********************************************************************
     */
    
    @Override
    public void writeObject(Object pojo) throws IOException {
        if (delegateCopyMethods) {
            delegate.writeObject(pojo);
            return;
        }
        if (pojo == null) {
            writeNull();
        } else {
            getObjectWriteContext().writeValue(this, pojo);
        }
    }
    
    @Override
    public void writeTree(TreeNode tree) throws IOException {
        if (delegateCopyMethods) {
            delegate.writeTree(tree);
            return;
        }
        // As with 'writeObject()', we are not check if write would work
        if (tree == null) {
            writeNull();
        } else {
            getObjectWriteContext().writeTree(this, tree);
        }
    }

    /*
    /**********************************************************************
    /* Public API, convenience field write methods
    /**********************************************************************
     */

    // // These are fine, just delegate to other methods...

    /*
    /**********************************************************************
    /* Public API, copy-through methods
    /**********************************************************************
     */

    @Override
    public void copyCurrentEvent(JsonParser p) throws IOException {
        if (delegateCopyMethods) delegate.copyCurrentEvent(p);
        else super.copyCurrentEvent(p);
    }

    @Override
    public void copyCurrentStructure(JsonParser p) throws IOException {
        if (delegateCopyMethods) delegate.copyCurrentStructure(p);
        else super.copyCurrentStructure(p);
    }

    /*
    /**********************************************************************
    /* Public API, context access
    /**********************************************************************
     */

    @Override public TokenStreamContext getOutputContext() { return delegate.getOutputContext(); }
    @Override public ObjectWriteContext getObjectWriteContext() { return delegate.getObjectWriteContext(); }

    /*
    /**********************************************************************
    /* Public API, buffer handling
    /**********************************************************************
     */
    
    @Override public void flush() throws IOException { delegate.flush(); }
    @Override public void close() throws IOException { delegate.close(); }

    /*
    /**********************************************************************
    /* Closeable implementation
    /**********************************************************************
     */
    
    @Override public boolean isClosed() { return delegate.isClosed(); }

    /*
    /**********************************************************************
    /* Extended API
    /**********************************************************************
     */

    public JsonGenerator delegate() { return delegate; }
}
