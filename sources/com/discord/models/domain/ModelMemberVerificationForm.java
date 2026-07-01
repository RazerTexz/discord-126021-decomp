package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationForm {
    private final List<ModelMemberVerificationForm$FormField> formFields;
    private final String version;

    public ModelMemberVerificationForm(String str, List<ModelMemberVerificationForm$FormField> list) {
        m.checkNotNullParameter(str, "version");
        m.checkNotNullParameter(list, "formFields");
        this.version = str;
        this.formFields = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationForm copy$default(ModelMemberVerificationForm modelMemberVerificationForm, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationForm.version;
        }
        if ((i & 2) != 0) {
            list = modelMemberVerificationForm.formFields;
        }
        return modelMemberVerificationForm.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<ModelMemberVerificationForm$FormField> component2() {
        return this.formFields;
    }

    public final ModelMemberVerificationForm copy(String version, List<ModelMemberVerificationForm$FormField> formFields) {
        m.checkNotNullParameter(version, "version");
        m.checkNotNullParameter(formFields, "formFields");
        return new ModelMemberVerificationForm(version, formFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationForm)) {
            return false;
        }
        ModelMemberVerificationForm modelMemberVerificationForm = (ModelMemberVerificationForm) other;
        return m.areEqual(this.version, modelMemberVerificationForm.version) && m.areEqual(this.formFields, modelMemberVerificationForm.formFields);
    }

    public final List<ModelMemberVerificationForm$FormField> getFormFields() {
        return this.formFields;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ModelMemberVerificationForm$FormField> list = this.formFields;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isFormOutdated() {
        List<ModelMemberVerificationForm$FormField> list = this.formFields;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ModelMemberVerificationForm$FormField) it.next()).getMemberVerificationFieldType() == ModelMemberVerificationForm$MemberVerificationFieldType.UNKNOWN) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelMemberVerificationForm(version=");
        sbU.append(this.version);
        sbU.append(", formFields=");
        return a.L(sbU, this.formFields, ")");
    }
}
