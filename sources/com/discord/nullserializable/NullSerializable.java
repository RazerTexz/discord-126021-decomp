package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class NullSerializable<T> implements Serializable {
    private final T value;

    /* JADX INFO: renamed from: com.discord.nullserializable.NullSerializable$a */
    /* JADX INFO: compiled from: NullSerializable.kt */
    public static final class C5565a<T> extends NullSerializable<T> {
        private final T value;

        public C5565a() {
            this(null, 1);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5565a(Object obj, int i) {
            super(null, null);
            int i2 = i & 1;
            this.value = null;
        }

        @Override // com.discord.nullserializable.NullSerializable
        /* JADX INFO: renamed from: a */
        public T mo8429a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof C5565a) && C12238m.areEqual(this.value, ((C5565a) obj).value);
            }
            return true;
        }

        public int hashCode() {
            T t = this.value;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Null(value=");
            sbM833U.append(this.value);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.nullserializable.NullSerializable$b */
    /* JADX INFO: compiled from: NullSerializable.kt */
    public static final class C5566b<T> extends NullSerializable<T> {
        private final T value;

        public C5566b(T t) {
            super(t, null);
            this.value = t;
        }

        @Override // com.discord.nullserializable.NullSerializable
        /* JADX INFO: renamed from: a */
        public T mo8429a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof C5566b) && C12238m.areEqual(this.value, ((C5566b) obj).value);
            }
            return true;
        }

        public int hashCode() {
            T t = this.value;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Value(value=");
            sbM833U.append(this.value);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullSerializable(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: a */
    public T mo8429a() {
        return this.value;
    }
}
