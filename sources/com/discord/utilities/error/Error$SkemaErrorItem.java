package com.discord.utilities.error;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class Error$SkemaErrorItem implements Model {
    private String code;
    private String message;

    private Error$SkemaErrorItem() {
    }

    public static /* synthetic */ String access$500(Error$SkemaErrorItem error$SkemaErrorItem) {
        return error$SkemaErrorItem.message;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_CODE)) {
            this.code = model$JsonReader.nextString(null);
        } else if (strNextName.equals("message")) {
            this.message = model$JsonReader.nextString(null);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Error$SkemaErrorItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Error$SkemaErrorItem)) {
            return false;
        }
        Error$SkemaErrorItem error$SkemaErrorItem = (Error$SkemaErrorItem) obj;
        if (!error$SkemaErrorItem.canEqual(this)) {
            return false;
        }
        String str = this.code;
        String str2 = error$SkemaErrorItem.code;
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String str3 = this.message;
        String str4 = error$SkemaErrorItem.message;
        return str3 != null ? str3.equals(str4) : str4 == null;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = str == null ? 43 : str.hashCode();
        String str2 = this.message;
        return ((iHashCode + 59) * 59) + (str2 != null ? str2.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("Error.SkemaErrorItem(code=");
        sbU.append(this.code);
        sbU.append(", message=");
        return a.J(sbU, this.message, ")");
    }

    public /* synthetic */ Error$SkemaErrorItem(Error$1 error$1) {
        this();
    }
}
