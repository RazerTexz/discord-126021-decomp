package com.discord.dialogs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.b0;
import com.discord.R$id;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ImageUploadDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ImageUploadDialog$c extends k implements Function1<View, b0> {
    public static final ImageUploadDialog$c j = new ImageUploadDialog$c();

    public ImageUploadDialog$c() {
        super(1, b0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b0 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = 2131364550;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(2131364550);
        if (materialButton != null) {
            i = R$id.notice_crop;
            TextView textView = (TextView) view2.findViewById(R$id.notice_crop);
            if (textView != null) {
                i = R$id.notice_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R$id.notice_image);
                if (simpleDraweeView != null) {
                    i = R$id.notice_upload;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.notice_upload);
                    if (materialButton2 != null) {
                        return new b0((LinearLayout) view2, materialButton, textView, simpleDraweeView, materialButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
