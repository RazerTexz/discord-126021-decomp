package com.discord.api.user;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: com.discord.api.user.NsfwAllowanceTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: NsfwAllowance.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NsfwAllowance2 extends TypeAdapter<NsfwAllowance> {

    /* JADX INFO: renamed from: com.discord.api.user.NsfwAllowanceTypeAdapter$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NsfwAllowance.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[NsfwAllowance.UNKNOWN.ordinal()] = 1;
            iArr[NsfwAllowance.ALLOWED.ordinal()] = 2;
            iArr[NsfwAllowance.DISALLOWED.ordinal()] = 3;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public NsfwAllowance read(JsonReader jsonReader) throws IOException {
        Boolean boolValueOf;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Intrinsics3.checkNotNullParameter(jsonReader, "$this$nextBooleanOrNull");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jsonReader.u());
        }
        if (Intrinsics3.areEqual(boolValueOf, Boolean.TRUE)) {
            return NsfwAllowance.ALLOWED;
        }
        if (Intrinsics3.areEqual(boolValueOf, Boolean.FALSE)) {
            return NsfwAllowance.DISALLOWED;
        }
        if (boolValueOf == null) {
            return NsfwAllowance.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, NsfwAllowance nsfwAllowance) throws IOException {
        Boolean bool;
        NsfwAllowance nsfwAllowance2 = nsfwAllowance;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (nsfwAllowance2 == null) {
            jsonWriter.s();
            return;
        }
        int iOrdinal = nsfwAllowance2.ordinal();
        if (iOrdinal == 0) {
            bool = null;
        } else if (iOrdinal == 1) {
            bool = Boolean.TRUE;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            bool = Boolean.FALSE;
        }
        jsonWriter.C(bool);
    }
}
