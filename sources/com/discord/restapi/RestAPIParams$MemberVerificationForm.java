package com.discord.restapi;

import com.discord.models.domain.ModelMemberVerificationForm$FormField;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$MemberVerificationForm {
    private final List<ModelMemberVerificationForm$FormField> formFields;
    private final String version;

    public RestAPIParams$MemberVerificationForm() {
        this(null, null, 3, null);
    }

    public RestAPIParams$MemberVerificationForm(List<ModelMemberVerificationForm$FormField> list, String str) {
        this.formFields = list;
        this.version = str;
    }

    public /* synthetic */ RestAPIParams$MemberVerificationForm(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
    }
}
