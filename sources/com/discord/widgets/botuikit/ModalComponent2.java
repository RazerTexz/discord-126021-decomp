package com.discord.widgets.botuikit;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.ViewInteractionModalBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$binding$2, reason: use source file name */
/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ModalComponent2 extends FunctionReferenceImpl implements Function1<View, ViewInteractionModalBinding> {
    public static final ModalComponent2 INSTANCE = new ModalComponent2();

    public ModalComponent2() {
        super(1, ViewInteractionModalBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewInteractionModalBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ViewInteractionModalBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close;
        ImageView imageView = (ImageView) view.findViewById(R.id.close);
        if (imageView != null) {
            i = R.id.components;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.components);
            if (linearLayout != null) {
                i = R.id.components_scroll;
                ScrollView scrollView = (ScrollView) view.findViewById(R.id.components_scroll);
                if (scrollView != null) {
                    i = R.id.error;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.error);
                    if (linearLayout2 != null) {
                        i = R.id.icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.icon);
                        if (simpleDraweeView != null) {
                            i = R.id.submit;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.submit);
                            if (materialButton != null) {
                                i = R.id.title;
                                TextView textView = (TextView) view.findViewById(R.id.title);
                                if (textView != null) {
                                    i = R.id.toolbar;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.toolbar);
                                    if (constraintLayout != null) {
                                        i = R.id.warning;
                                        TextView textView2 = (TextView) view.findViewById(R.id.warning);
                                        if (textView2 != null) {
                                            return new ViewInteractionModalBinding((LinearLayout) view, imageView, linearLayout, scrollView, linearLayout2, simpleDraweeView, materialButton, textView, constraintLayout, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
