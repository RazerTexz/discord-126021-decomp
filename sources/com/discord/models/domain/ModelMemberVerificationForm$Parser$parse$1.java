package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$Parser$parse$1<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $formFields;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $version;

    public ModelMemberVerificationForm$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$version = ref$ObjectRef;
        this.$reader = model$JsonReader;
        this.$formFields = ref$ObjectRef2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -708425068) {
                if (iHashCode == 351608024 && str.equals("version")) {
                    Ref$ObjectRef ref$ObjectRef = this.$version;
                    T t = (T) this.$reader.nextString("");
                    m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                    ref$ObjectRef.element = t;
                    return;
                }
            } else if (str.equals("form_fields")) {
                Ref$ObjectRef ref$ObjectRef2 = this.$formFields;
                T t2 = (T) this.$reader.nextList(new ModelMemberVerificationForm$Parser$parse$1$1(this));
                m.checkNotNullExpressionValue(t2, "reader.nextList { FormField.Parser.parse(reader) }");
                ref$ObjectRef2.element = t2;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
