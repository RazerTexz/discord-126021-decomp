package com.discord.models.experiments.dto;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p408d.InterfaceC4911o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserExperimentDto {
    private final int bucket;
    private final long nameHash;
    private final int population;
    private final int revision;

    /* JADX INFO: compiled from: UserExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final UserExperimentDto parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$1
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRefM844c0.element = reader.nextLongOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$2
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef.element = reader.nextIntOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$3
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef2.element = reader.nextIntOrNull();
                }
            }, new Runnable() { // from class: com.discord.models.experiments.dto.UserExperimentDto$Parser$parse$4
                /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
                @Override // java.lang.Runnable
                public final void run() {
                    ref$ObjectRef3.element = reader.nextIntOrNull();
                }
            });
            Long l = (Long) ref$ObjectRefM844c0.element;
            C12238m.checkNotNull(l);
            long jLongValue = l.longValue();
            Integer num = (Integer) ref$ObjectRef.element;
            C12238m.checkNotNull(num);
            int iIntValue = num.intValue();
            Integer num2 = (Integer) ref$ObjectRef2.element;
            C12238m.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Integer num3 = (Integer) ref$ObjectRef3.element;
            C12238m.checkNotNull(num3);
            return new UserExperimentDto(jLongValue, iIntValue, iIntValue2, num3.intValue());
        }
    }

    /* JADX INFO: compiled from: UserExperimentDto.kt */
    public static final class TypeAdapterFactory implements InterfaceC4911o {
        public static final TypeAdapterFactory INSTANCE = new TypeAdapterFactory();

        /* JADX INFO: compiled from: UserExperimentDto.kt */
        public static final class TypeAdapter extends com.google.gson.TypeAdapter<UserExperimentDto> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public UserExperimentDto read(JsonReader in) {
                return Parser.parse(new Model.JsonReader(in));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter out, UserExperimentDto value) {
                throw new UnsupportedOperationException();
            }
        }

        private TypeAdapterFactory() {
        }

        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> com.google.gson.TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (gson == null || type == null || !UserExperimentDto.class.isAssignableFrom(type.getRawType())) {
                return null;
            }
            return new TypeAdapter();
        }
    }

    public UserExperimentDto(long j, int i, int i2, int i3) {
        this.nameHash = j;
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
    }

    public static /* synthetic */ UserExperimentDto copy$default(UserExperimentDto userExperimentDto, long j, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = userExperimentDto.nameHash;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            i = userExperimentDto.revision;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = userExperimentDto.bucket;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = userExperimentDto.population;
        }
        return userExperimentDto.copy(j2, i5, i6, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getNameHash() {
        return this.nameHash;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    public final UserExperimentDto copy(long nameHash, int revision, int bucket, int population) {
        return new UserExperimentDto(nameHash, revision, bucket, population);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserExperimentDto)) {
            return false;
        }
        UserExperimentDto userExperimentDto = (UserExperimentDto) other;
        return this.nameHash == userExperimentDto.nameHash && this.revision == userExperimentDto.revision && this.bucket == userExperimentDto.bucket && this.population == userExperimentDto.population;
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final long getNameHash() {
        return this.nameHash;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.nameHash;
        return (((((((int) (j ^ (j >>> 32))) * 31) + this.revision) * 31) + this.bucket) * 31) + this.population;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("UserExperimentDto(nameHash=");
        sbM833U.append(this.nameHash);
        sbM833U.append(", revision=");
        sbM833U.append(this.revision);
        sbM833U.append(", bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", population=");
        return C1643a.m814B(sbM833U, this.population, ")");
    }
}
