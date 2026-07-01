package com.discord.utilities.error;

import androidx.annotation.NonNull;
import b.a.x.a.b;
import b.d.b.a.a;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Error$SkemaError implements Model {

    @NonNull
    private List<Error$SkemaErrorItem> errors;

    @NonNull
    private Map<String, Error$SkemaError> subErrors;

    private Error$SkemaError() {
        this.errors = Collections.emptyList();
        this.subErrors = new HashMap();
    }

    public static /* synthetic */ List access$400(Error$SkemaError error$SkemaError) {
        return error$SkemaError.errors;
    }

    public static /* synthetic */ Map access$600(Error$SkemaError error$SkemaError) {
        return error$SkemaError.subErrors;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        if ("_errors".equals(strNextName)) {
            this.errors = model$JsonReader.nextList(new b(model$JsonReader));
        } else {
            this.subErrors.put(strNextName, (Error$SkemaError) model$JsonReader.parse(new Error$SkemaError()));
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Error$SkemaError;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Error$SkemaError)) {
            return false;
        }
        Error$SkemaError error$SkemaError = (Error$SkemaError) obj;
        if (!error$SkemaError.canEqual(this)) {
            return false;
        }
        List<Error$SkemaErrorItem> list = this.errors;
        List<Error$SkemaErrorItem> list2 = error$SkemaError.errors;
        if (list != null ? !list.equals(list2) : list2 != null) {
            return false;
        }
        Map<String, Error$SkemaError> map = this.subErrors;
        Map<String, Error$SkemaError> map2 = error$SkemaError.subErrors;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public int hashCode() {
        List<Error$SkemaErrorItem> list = this.errors;
        int iHashCode = list == null ? 43 : list.hashCode();
        Map<String, Error$SkemaError> map = this.subErrors;
        return ((iHashCode + 59) * 59) + (map != null ? map.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("Error.SkemaError(errors=");
        sbU.append(this.errors);
        sbU.append(", subErrors=");
        return a.M(sbU, this.subErrors, ")");
    }

    public /* synthetic */ Error$SkemaError(Error$1 error$1) {
        this();
    }
}
