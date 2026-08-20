package com.discord.widgets.settings.billing;

import android.content.Context;
import android.content.res.AssetManager;
import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.functions.Function0;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$usStates$2 extends AbstractC12240o implements Function0<WidgetPaymentSourceEditDialog.StateEntry[]> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$usStates$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public final WidgetPaymentSourceEditDialog.StateEntry[] invoke() throws IOException {
        AssetManager assets;
        Context context = this.this$0.getContext();
        InputStreamReader inputStreamReader = new InputStreamReader((context == null || (assets = context.getAssets()) == null) ? null : assets.open("data/states.json"), Constants.ENCODING);
        try {
            WidgetPaymentSourceEditDialog.StateEntry[] stateEntryArr = (WidgetPaymentSourceEditDialog.StateEntry[]) new Gson().m9201e(inputStreamReader, WidgetPaymentSourceEditDialog.StateEntry[].class);
            C12201b.closeFinally(inputStreamReader, null);
            return stateEntryArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }
}
