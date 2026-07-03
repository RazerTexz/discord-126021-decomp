package com.discord.api.user;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NsfwAllowance.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NsfwAllowanceTypeAdapter extends TypeAdapter<NsfwAllowance> {

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
        C12238m.checkNotNullParameter(jsonReader, "in");
        C12238m.checkNotNullParameter(jsonReader, "$this$nextBooleanOrNull");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jsonReader.mo6889u());
        }
        if (C12238m.areEqual(boolValueOf, Boolean.TRUE)) {
            return NsfwAllowance.ALLOWED;
        }
        if (C12238m.areEqual(boolValueOf, Boolean.FALSE)) {
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (nsfwAllowance2 == null) {
            jsonWriter.mo6905s();
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
        jsonWriter.mo6893C(bool);
    }
}
