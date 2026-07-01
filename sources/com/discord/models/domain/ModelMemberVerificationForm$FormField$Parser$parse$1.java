package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$FormField$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $choices;
    public final /* synthetic */ Ref$ObjectRef $fieldType;
    public final /* synthetic */ Ref$ObjectRef $label;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$BooleanRef $required;
    public final /* synthetic */ Ref$ObjectRef $response;
    public final /* synthetic */ Ref$ObjectRef $values;

    public ModelMemberVerificationForm$FormField$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        this.$fieldType = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$label = ref$ObjectRef2;
        this.$required = ref$BooleanRef;
        this.$values = ref$ObjectRef3;
        this.$choices = ref$ObjectRef4;
        this.$response = ref$ObjectRef5;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            switch (str.hashCode()) {
                case -823812830:
                    if (str.equals("values")) {
                        Ref$ObjectRef ref$ObjectRef = this.$values;
                        T t = (T) this.$reader.nextList(new ModelMemberVerificationForm$FormField$Parser$parse$1$1(this));
                        m.checkNotNullExpressionValue(t, "reader.nextList { reader.nextString(\"\") }");
                        ref$ObjectRef.element = t;
                        return;
                    }
                    break;
                case -393139297:
                    if (str.equals("required")) {
                        this.$required.element = this.$reader.nextBoolean(false);
                        return;
                    }
                    break;
                case -340323263:
                    if (str.equals("response")) {
                        T t2 = this.$fieldType.element;
                        if (t2 == null) {
                            m.throwUninitializedPropertyAccessException("fieldType");
                        }
                        String str2 = (String) t2;
                        if (str2.hashCode() == 1121961648 && str2.equals("MULTIPLE_CHOICE")) {
                            this.$response.element = (T) Integer.valueOf(this.$reader.nextInt(-1));
                            return;
                        } else {
                            Ref$ObjectRef ref$ObjectRef2 = this.$response;
                            T t3 = (T) this.$reader.nextString("");
                            m.checkNotNullExpressionValue(t3, "reader.nextString(\"\")");
                            ref$ObjectRef2.element = t3;
                            return;
                        }
                    }
                    break;
                case 102727412:
                    if (str.equals("label")) {
                        Ref$ObjectRef ref$ObjectRef3 = this.$label;
                        T t4 = (T) this.$reader.nextString("");
                        m.checkNotNullExpressionValue(t4, "reader.nextString(\"\")");
                        ref$ObjectRef3.element = t4;
                        return;
                    }
                    break;
                case 576861023:
                    if (str.equals("field_type")) {
                        Ref$ObjectRef ref$ObjectRef4 = this.$fieldType;
                        T t5 = (T) this.$reader.nextString("");
                        m.checkNotNullExpressionValue(t5, "reader.nextString(\"\")");
                        ref$ObjectRef4.element = t5;
                        return;
                    }
                    break;
                case 751720178:
                    if (str.equals("choices")) {
                        Ref$ObjectRef ref$ObjectRef5 = this.$choices;
                        T t6 = (T) this.$reader.nextList(new ModelMemberVerificationForm$FormField$Parser$parse$1$2(this));
                        m.checkNotNullExpressionValue(t6, "reader.nextList { reader.nextString(\"\") }");
                        ref$ObjectRef5.element = t6;
                        return;
                    }
                    break;
            }
        }
        this.$reader.skipValue();
    }
}
