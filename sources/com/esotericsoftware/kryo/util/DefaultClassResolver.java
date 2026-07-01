package com.esotericsoftware.kryo.util;

import b.d.b.a.outline;
import b.e.a.Log;
import com.esotericsoftware.kryo.ClassResolver;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

/* JADX INFO: loaded from: classes.dex */
public class DefaultClassResolver implements ClassResolver {
    public static final byte NAME = -1;
    public IdentityObjectIntMap<Class> classToNameId;
    public Kryo kryo;
    private Class memoizedClass;
    private Registration memoizedClassIdValue;
    private Registration memoizedClassValue;
    public IntMap<Class> nameIdToClass;
    public ObjectMap<String, Class> nameToClass;
    public int nextNameId;
    public final IntMap<Registration> idToRegistration = new IntMap<>();
    public final ObjectMap<Class, Registration> classToRegistration = new ObjectMap<>();
    private int memoizedClassId = -1;

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration getRegistration(Class cls) {
        if (cls == this.memoizedClass) {
            return this.memoizedClassValue;
        }
        Registration registration = this.classToRegistration.get(cls);
        if (registration != null) {
            this.memoizedClass = cls;
            this.memoizedClassValue = registration;
        }
        return registration;
    }

    public Class<?> getTypeByName(String str) {
        ObjectMap<String, Class> objectMap = this.nameToClass;
        if (objectMap != null) {
            return objectMap.get(str);
        }
        return null;
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration readClass(Input input) {
        int varInt = input.readVarInt(true);
        if (varInt == 0) {
            Log.a aVar = Log.a;
            return null;
        }
        if (varInt == 1) {
            return readName(input);
        }
        if (varInt == this.memoizedClassId) {
            return this.memoizedClassIdValue;
        }
        int i = varInt - 2;
        Registration registration = this.idToRegistration.get(i);
        if (registration == null) {
            throw new KryoException(outline.q("Encountered unregistered class ID: ", i));
        }
        Log.a aVar2 = Log.a;
        this.memoizedClassId = varInt;
        this.memoizedClassIdValue = registration;
        return registration;
    }

    public Registration readName(Input input) {
        int varInt = input.readVarInt(true);
        if (this.nameIdToClass == null) {
            this.nameIdToClass = new IntMap<>();
        }
        Class typeByName = this.nameIdToClass.get(varInt);
        if (typeByName == null) {
            String string = input.readString();
            typeByName = getTypeByName(string);
            if (typeByName == null) {
                try {
                    typeByName = Class.forName(string, false, this.kryo.getClassLoader());
                } catch (ClassNotFoundException e) {
                    Log.a aVar = Log.a;
                    Log.a.a(4, "kryo", outline.y("Unable to load class ", string, " with kryo's ClassLoader. Retrying with current.."), null);
                    try {
                        typeByName = Class.forName(string);
                    } catch (ClassNotFoundException unused) {
                        throw new KryoException(outline.w("Unable to find class: ", string), e);
                    }
                }
                if (this.nameToClass == null) {
                    this.nameToClass = new ObjectMap<>();
                }
                this.nameToClass.put(string, typeByName);
            }
            this.nameIdToClass.put(varInt, typeByName);
            Log.a aVar2 = Log.a;
        } else {
            Log.a aVar3 = Log.a;
        }
        return this.kryo.getRegistration(typeByName);
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration register(Registration registration) {
        if (registration == null) {
            throw new IllegalArgumentException("registration cannot be null.");
        }
        if (registration.getId() != -1) {
            Log.a aVar = Log.a;
            this.idToRegistration.put(registration.getId(), registration);
        } else {
            Log.a aVar2 = Log.a;
        }
        this.classToRegistration.put(registration.getType(), registration);
        if (registration.getType().isPrimitive()) {
            this.classToRegistration.put(Util.getWrapperClass(registration.getType()), registration);
        }
        return registration;
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration registerImplicit(Class cls) {
        return register(new Registration(cls, this.kryo.getDefaultSerializer(cls), -1));
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public void reset() {
        if (this.kryo.isRegistrationRequired()) {
            return;
        }
        IdentityObjectIntMap<Class> identityObjectIntMap = this.classToNameId;
        if (identityObjectIntMap != null) {
            identityObjectIntMap.clear(2048);
        }
        IntMap<Class> intMap = this.nameIdToClass;
        if (intMap != null) {
            intMap.clear();
        }
        this.nextNameId = 0;
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public void setKryo(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration writeClass(Output output, Class cls) {
        if (cls == null) {
            Log.a aVar = Log.a;
            output.writeVarInt(0, true);
            return null;
        }
        Registration registration = this.kryo.getRegistration(cls);
        if (registration.getId() == -1) {
            writeName(output, cls, registration);
        } else {
            Log.a aVar2 = Log.a;
            output.writeVarInt(registration.getId() + 2, true);
        }
        return registration;
    }

    public void writeName(Output output, Class cls, Registration registration) {
        int i;
        output.writeVarInt(1, true);
        IdentityObjectIntMap<Class> identityObjectIntMap = this.classToNameId;
        if (identityObjectIntMap != null && (i = identityObjectIntMap.get(cls, -1)) != -1) {
            Log.a aVar = Log.a;
            output.writeVarInt(i, true);
            return;
        }
        Log.a aVar2 = Log.a;
        int i2 = this.nextNameId;
        this.nextNameId = i2 + 1;
        if (this.classToNameId == null) {
            this.classToNameId = new IdentityObjectIntMap<>();
        }
        this.classToNameId.put(cls, i2);
        output.writeVarInt(i2, true);
        output.writeString(cls.getName());
    }

    @Override // com.esotericsoftware.kryo.ClassResolver
    public Registration getRegistration(int i) {
        return this.idToRegistration.get(i);
    }
}
