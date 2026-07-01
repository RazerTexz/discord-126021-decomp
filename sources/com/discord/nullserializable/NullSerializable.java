package com.discord.nullserializable;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NullSerializable.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class NullSerializable<T> implements Serializable {
    private final T value;

    /* JADX INFO: compiled from: NullSerializable.kt */
    public static final class a<T> extends NullSerializable<T> {
        private final T value;

        public a() {
            this(null, 1);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, int i) {
            super(null, null);
            int i2 = i & 1;
            this.value = null;
        }

        @Override // com.discord.nullserializable.NullSerializable
        public T a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && Intrinsics3.areEqual(this.value, ((a) obj).value);
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
            StringBuilder sbU = outline.U("Null(value=");
            sbU.append(this.value);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: NullSerializable.kt */
    public static final class b<T> extends NullSerializable<T> {
        private final T value;

        public b(T t) {
            super(t, null);
            this.value = t;
        }

        @Override // com.discord.nullserializable.NullSerializable
        public T a() {
            return this.value;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && Intrinsics3.areEqual(this.value, ((b) obj).value);
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
            StringBuilder sbU = outline.U("Value(value=");
            sbU.append(this.value);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullSerializable(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this.value = obj;
    }

    public T a() {
        return this.value;
    }
}
