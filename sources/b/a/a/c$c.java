package b.a.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.c0;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c$c extends d0.z.d.k implements Function1<View, c0> {
    public static final c$c j = new c$c();

    public c$c() {
        super(1, c0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ImageUploadFailedDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public c0 invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.chat_input_upload_too_large_center_file;
        ImageView imageView = (ImageView) view2.findViewById(R$id.chat_input_upload_too_large_center_file);
        if (imageView != null) {
            i = R$id.image_upload_failed_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.image_upload_failed_cancel);
            if (materialButton != null) {
                i = R$id.image_upload_failed_compression_settings_checkbox;
                SwitchMaterial switchMaterial = (SwitchMaterial) view2.findViewById(R$id.image_upload_failed_compression_settings_checkbox);
                if (switchMaterial != null) {
                    i = R$id.image_upload_failed_compression_settings_container;
                    RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R$id.image_upload_failed_compression_settings_container);
                    if (relativeLayout != null) {
                        i = R$id.image_upload_failed_divider;
                        View viewFindViewById = view2.findViewById(R$id.image_upload_failed_divider);
                        if (viewFindViewById != null) {
                            i = R$id.image_upload_failed_nitro;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.image_upload_failed_nitro);
                            if (materialButton2 != null) {
                                i = R$id.image_upload_failed_nitro_wrapper;
                                RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R$id.image_upload_failed_nitro_wrapper);
                                if (relativeLayout2 != null) {
                                    i = R$id.image_upload_failed_okay;
                                    MaterialButton materialButton3 = (MaterialButton) view2.findViewById(R$id.image_upload_failed_okay);
                                    if (materialButton3 != null) {
                                        i = R$id.image_upload_failed_send_compress;
                                        MaterialButton materialButton4 = (MaterialButton) view2.findViewById(R$id.image_upload_failed_send_compress);
                                        if (materialButton4 != null) {
                                            i = R$id.image_upload_failed_text;
                                            TextView textView = (TextView) view2.findViewById(R$id.image_upload_failed_text);
                                            if (textView != null) {
                                                i = R$id.setting_label;
                                                TextView textView2 = (TextView) view2.findViewById(R$id.setting_label);
                                                if (textView2 != null) {
                                                    i = R$id.setting_subtext;
                                                    TextView textView3 = (TextView) view2.findViewById(R$id.setting_subtext);
                                                    if (textView3 != null) {
                                                        return new c0((RelativeLayout) view2, imageView, materialButton, switchMaterial, relativeLayout, viewFindViewById, materialButton2, relativeLayout2, materialButton3, materialButton4, textView, textView2, textView3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
