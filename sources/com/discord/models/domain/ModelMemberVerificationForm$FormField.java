package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationForm$FormField {
    private final List<String> choices;
    private final String fieldType;
    private final String label;
    private final boolean required;
    private Object response;
    private final List<String> values;

    public ModelMemberVerificationForm$FormField(String str, String str2, boolean z2, List<String> list, List<String> list2, Object obj) {
        m.checkNotNullParameter(str, "fieldType");
        m.checkNotNullParameter(str2, "label");
        m.checkNotNullParameter(list, "values");
        m.checkNotNullParameter(list2, "choices");
        m.checkNotNullParameter(obj, "response");
        this.fieldType = str;
        this.label = str2;
        this.required = z2;
        this.values = list;
        this.choices = list2;
        this.response = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationForm$FormField copy$default(ModelMemberVerificationForm$FormField modelMemberVerificationForm$FormField, String str, String str2, boolean z2, List list, List list2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationForm$FormField.fieldType;
        }
        if ((i & 2) != 0) {
            str2 = modelMemberVerificationForm$FormField.label;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z2 = modelMemberVerificationForm$FormField.required;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            list = modelMemberVerificationForm$FormField.values;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = modelMemberVerificationForm$FormField.choices;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            obj = modelMemberVerificationForm$FormField.response;
        }
        return modelMemberVerificationForm$FormField.copy(str, str3, z3, list3, list4, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFieldType() {
        return this.fieldType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    public final List<String> component4() {
        return this.values;
    }

    public final List<String> component5() {
        return this.choices;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getResponse() {
        return this.response;
    }

    public final ModelMemberVerificationForm$FormField copy(String fieldType, String label, boolean required, List<String> values, List<String> choices, Object response) {
        m.checkNotNullParameter(fieldType, "fieldType");
        m.checkNotNullParameter(label, "label");
        m.checkNotNullParameter(values, "values");
        m.checkNotNullParameter(choices, "choices");
        m.checkNotNullParameter(response, "response");
        return new ModelMemberVerificationForm$FormField(fieldType, label, required, values, choices, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationForm$FormField)) {
            return false;
        }
        ModelMemberVerificationForm$FormField modelMemberVerificationForm$FormField = (ModelMemberVerificationForm$FormField) other;
        return m.areEqual(this.fieldType, modelMemberVerificationForm$FormField.fieldType) && m.areEqual(this.label, modelMemberVerificationForm$FormField.label) && this.required == modelMemberVerificationForm$FormField.required && m.areEqual(this.values, modelMemberVerificationForm$FormField.values) && m.areEqual(this.choices, modelMemberVerificationForm$FormField.choices) && m.areEqual(this.response, modelMemberVerificationForm$FormField.response);
    }

    public final List<String> getChoices() {
        return this.choices;
    }

    public final String getFieldType() {
        return this.fieldType;
    }

    public final String getLabel() {
        return this.label;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final ModelMemberVerificationForm$MemberVerificationFieldType getMemberVerificationFieldType() {
        String str = this.fieldType;
        switch (str.hashCode()) {
            case -708597224:
                if (str.equals("TEXT_INPUT")) {
                    return ModelMemberVerificationForm$MemberVerificationFieldType.TEXT_INPUT;
                }
                break;
            case 79712615:
                if (str.equals("TERMS")) {
                    return ModelMemberVerificationForm$MemberVerificationFieldType.TERMS;
                }
                break;
            case 440916302:
                if (str.equals("PARAGRAPH")) {
                    return ModelMemberVerificationForm$MemberVerificationFieldType.PARAGRAPH;
                }
                break;
            case 1121961648:
                if (str.equals("MULTIPLE_CHOICE")) {
                    return ModelMemberVerificationForm$MemberVerificationFieldType.MULTIPLE_CHOICE;
                }
                break;
        }
        return ModelMemberVerificationForm$MemberVerificationFieldType.UNKNOWN;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final Object getResponse() {
        return this.response;
    }

    public final List<String> getValues() {
        return this.values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        String str = this.fieldType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        List<String> list = this.values;
        int iHashCode3 = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.choices;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Object obj = this.response;
        return iHashCode4 + (obj != null ? obj.hashCode() : 0);
    }

    public final void setResponse(Object obj) {
        m.checkNotNullParameter(obj, "<set-?>");
        this.response = obj;
    }

    public String toString() {
        StringBuilder sbU = a.U("FormField(fieldType=");
        sbU.append(this.fieldType);
        sbU.append(", label=");
        sbU.append(this.label);
        sbU.append(", required=");
        sbU.append(this.required);
        sbU.append(", values=");
        sbU.append(this.values);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", response=");
        sbU.append(this.response);
        sbU.append(")");
        return sbU.toString();
    }
}
