package com.discord.widgets.settings.billing;

import android.content.Context;
import android.content.res.AssetManager;
import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import d0.y.b;
import d0.z.d.o;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$caProvinces$2 extends o implements Function0<WidgetPaymentSourceEditDialog$StateEntry[]> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$caProvinces$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetPaymentSourceEditDialog$StateEntry[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPaymentSourceEditDialog$StateEntry[] invoke2() throws IOException {
        AssetManager assets;
        Context context = this.this$0.getContext();
        InputStreamReader inputStreamReader = new InputStreamReader((context == null || (assets = context.getAssets()) == null) ? null : assets.open("data/canadian-provinces.json"), Constants.ENCODING);
        try {
            WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr = (WidgetPaymentSourceEditDialog$StateEntry[]) new Gson().e(inputStreamReader, WidgetPaymentSourceEditDialog$StateEntry[].class);
            b.closeFinally(inputStreamReader, null);
            return widgetPaymentSourceEditDialog$StateEntryArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }
}
