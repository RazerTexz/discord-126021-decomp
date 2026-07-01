package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelMemberVerificationForm;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationForm {
    private final List<FormField> formFields;
    private final String version;

    /* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
    public static final /* data */ class FormField {
        private final List<String> choices;
        private final String fieldType;
        private final String label;
        private final boolean required;
        private Object response;
        private final List<String> values;

        /* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
        public static final class Parser implements Model.Parser<FormField> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public FormField parse(final Model.JsonReader reader) throws IOException {
                final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                ref$ObjectRefC0.element = null;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = false;
                final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = null;
                final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = null;
                final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                ref$ObjectRef4.element = null;
                reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1
                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                    @Override // rx.functions.Action1
                    public final void call(String str) throws IOException {
                        if (str != null) {
                            switch (str.hashCode()) {
                                case -823812830:
                                    if (str.equals("values")) {
                                        Ref$ObjectRef ref$ObjectRef5 = ref$ObjectRef2;
                                        T t = (T) reader.nextList(new Model.JsonReader.ItemFactory<String>() { // from class: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1.1
                                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                            public final String get() {
                                                return reader.nextString("");
                                            }
                                        });
                                        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { reader.nextString(\"\") }");
                                        ref$ObjectRef5.element = t;
                                        return;
                                    }
                                    break;
                                case -393139297:
                                    if (str.equals("required")) {
                                        ref$BooleanRef.element = reader.nextBoolean(false);
                                        return;
                                    }
                                    break;
                                case -340323263:
                                    if (str.equals("response")) {
                                        T t2 = ref$ObjectRefC0.element;
                                        if (t2 == null) {
                                            Intrinsics3.throwUninitializedPropertyAccessException("fieldType");
                                        }
                                        String str2 = (String) t2;
                                        if (str2.hashCode() == 1121961648 && str2.equals("MULTIPLE_CHOICE")) {
                                            ref$ObjectRef4.element = (T) Integer.valueOf(reader.nextInt(-1));
                                            return;
                                        } else {
                                            Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef4;
                                            T t3 = (T) reader.nextString("");
                                            Intrinsics3.checkNotNullExpressionValue(t3, "reader.nextString(\"\")");
                                            ref$ObjectRef6.element = t3;
                                            return;
                                        }
                                    }
                                    break;
                                case 102727412:
                                    if (str.equals("label")) {
                                        Ref$ObjectRef ref$ObjectRef7 = ref$ObjectRef;
                                        T t4 = (T) reader.nextString("");
                                        Intrinsics3.checkNotNullExpressionValue(t4, "reader.nextString(\"\")");
                                        ref$ObjectRef7.element = t4;
                                        return;
                                    }
                                    break;
                                case 576861023:
                                    if (str.equals("field_type")) {
                                        Ref$ObjectRef ref$ObjectRef8 = ref$ObjectRefC0;
                                        T t5 = (T) reader.nextString("");
                                        Intrinsics3.checkNotNullExpressionValue(t5, "reader.nextString(\"\")");
                                        ref$ObjectRef8.element = t5;
                                        return;
                                    }
                                    break;
                                case 751720178:
                                    if (str.equals("choices")) {
                                        Ref$ObjectRef ref$ObjectRef9 = ref$ObjectRef3;
                                        T t6 = (T) reader.nextList(new Model.JsonReader.ItemFactory<String>() { // from class: com.discord.models.domain.ModelMemberVerificationForm$FormField$Parser$parse$1.2
                                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                            public final String get() {
                                                return reader.nextString("");
                                            }
                                        });
                                        Intrinsics3.checkNotNullExpressionValue(t6, "reader.nextList { reader.nextString(\"\") }");
                                        ref$ObjectRef9.element = t6;
                                        return;
                                    }
                                    break;
                            }
                        }
                        reader.skipValue();
                    }
                });
                T t = ref$ObjectRefC0.element;
                if (t == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("fieldType");
                }
                String str = (String) t;
                T t2 = ref$ObjectRef.element;
                if (t2 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("label");
                }
                String str2 = (String) t2;
                boolean z2 = ref$BooleanRef.element;
                T t3 = ref$ObjectRef2.element;
                if (t3 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("values");
                }
                List list = (List) t3;
                T t4 = ref$ObjectRef3.element;
                if (t4 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("choices");
                }
                List list2 = (List) t4;
                T t5 = ref$ObjectRef4.element;
                if (t5 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("response");
                }
                return new FormField(str, str2, z2, list, list2, t5);
            }
        }

        public FormField(String str, String str2, boolean z2, List<String> list, List<String> list2, Object obj) {
            Intrinsics3.checkNotNullParameter(str, "fieldType");
            Intrinsics3.checkNotNullParameter(str2, "label");
            Intrinsics3.checkNotNullParameter(list, "values");
            Intrinsics3.checkNotNullParameter(list2, "choices");
            Intrinsics3.checkNotNullParameter(obj, "response");
            this.fieldType = str;
            this.label = str2;
            this.required = z2;
            this.values = list;
            this.choices = list2;
            this.response = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FormField copy$default(FormField formField, String str, String str2, boolean z2, List list, List list2, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = formField.fieldType;
            }
            if ((i & 2) != 0) {
                str2 = formField.label;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                z2 = formField.required;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                list = formField.values;
            }
            List list3 = list;
            if ((i & 16) != 0) {
                list2 = formField.choices;
            }
            List list4 = list2;
            if ((i & 32) != 0) {
                obj = formField.response;
            }
            return formField.copy(str, str3, z3, list3, list4, obj);
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

        public final FormField copy(String fieldType, String label, boolean required, List<String> values, List<String> choices, Object response) {
            Intrinsics3.checkNotNullParameter(fieldType, "fieldType");
            Intrinsics3.checkNotNullParameter(label, "label");
            Intrinsics3.checkNotNullParameter(values, "values");
            Intrinsics3.checkNotNullParameter(choices, "choices");
            Intrinsics3.checkNotNullParameter(response, "response");
            return new FormField(fieldType, label, required, values, choices, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormField)) {
                return false;
            }
            FormField formField = (FormField) other;
            return Intrinsics3.areEqual(this.fieldType, formField.fieldType) && Intrinsics3.areEqual(this.label, formField.label) && this.required == formField.required && Intrinsics3.areEqual(this.values, formField.values) && Intrinsics3.areEqual(this.choices, formField.choices) && Intrinsics3.areEqual(this.response, formField.response);
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
        public final MemberVerificationFieldType getMemberVerificationFieldType() {
            String str = this.fieldType;
            switch (str.hashCode()) {
                case -708597224:
                    if (str.equals("TEXT_INPUT")) {
                        return MemberVerificationFieldType.TEXT_INPUT;
                    }
                    break;
                case 79712615:
                    if (str.equals("TERMS")) {
                        return MemberVerificationFieldType.TERMS;
                    }
                    break;
                case 440916302:
                    if (str.equals("PARAGRAPH")) {
                        return MemberVerificationFieldType.PARAGRAPH;
                    }
                    break;
                case 1121961648:
                    if (str.equals("MULTIPLE_CHOICE")) {
                        return MemberVerificationFieldType.MULTIPLE_CHOICE;
                    }
                    break;
            }
            return MemberVerificationFieldType.UNKNOWN;
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
            Intrinsics3.checkNotNullParameter(obj, "<set-?>");
            this.response = obj;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FormField(fieldType=");
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

    /* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
    public enum MemberVerificationFieldType {
        UNKNOWN,
        TERMS,
        TEXT_INPUT,
        PARAGRAPH,
        MULTIPLE_CHOICE
    }

    /* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
    public static final class Parser implements Model.Parser<ModelMemberVerificationForm> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelMemberVerificationForm parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -708425068) {
                            if (iHashCode == 351608024 && str.equals("version")) {
                                Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRefC0;
                                T t = (T) reader.nextString("");
                                Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                                ref$ObjectRef2.element = t;
                                return;
                            }
                        } else if (str.equals("form_fields")) {
                            Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                            T t2 = (T) reader.nextList(new Model.JsonReader.ItemFactory<ModelMemberVerificationForm.FormField>() { // from class: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                public final ModelMemberVerificationForm.FormField get() {
                                    return ModelMemberVerificationForm.FormField.Parser.INSTANCE.parse(reader);
                                }
                            });
                            Intrinsics3.checkNotNullExpressionValue(t2, "reader.nextList { FormField.Parser.parse(reader) }");
                            ref$ObjectRef3.element = t2;
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("version");
            }
            String str = (String) t;
            T t2 = ref$ObjectRef.element;
            if (t2 == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("formFields");
            }
            return new ModelMemberVerificationForm(str, (List) t2);
        }
    }

    public ModelMemberVerificationForm(String str, List<FormField> list) {
        Intrinsics3.checkNotNullParameter(str, "version");
        Intrinsics3.checkNotNullParameter(list, "formFields");
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

    public final List<FormField> component2() {
        return this.formFields;
    }

    public final ModelMemberVerificationForm copy(String version, List<FormField> formFields) {
        Intrinsics3.checkNotNullParameter(version, "version");
        Intrinsics3.checkNotNullParameter(formFields, "formFields");
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
        return Intrinsics3.areEqual(this.version, modelMemberVerificationForm.version) && Intrinsics3.areEqual(this.formFields, modelMemberVerificationForm.formFields);
    }

    public final List<FormField> getFormFields() {
        return this.formFields;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FormField> list = this.formFields;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isFormOutdated() {
        List<FormField> list = this.formFields;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FormField) it.next()).getMemberVerificationFieldType() == MemberVerificationFieldType.UNKNOWN) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelMemberVerificationForm(version=");
        sbU.append(this.version);
        sbU.append(", formFields=");
        return outline.L(sbU, this.formFields, ")");
    }
}
