package com.discord.widgets.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsMediaBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsMedia$binding$2 extends C12236k implements Function1<View, WidgetSettingsMediaBinding> {
    public static final WidgetSettingsMedia$binding$2 INSTANCE = new WidgetSettingsMedia$binding$2();

    public WidgetSettingsMedia$binding$2() {
        super(1, WidgetSettingsMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsMediaBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.attachments_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.attachments_toggle);
        if (checkedSetting != null) {
            i = C5419R.id.compression_toggle;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.compression_toggle);
            if (checkedSetting2 != null) {
                i = C5419R.id.compression_toggle_subtext;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.compression_toggle_subtext);
                if (linkifiedTextView != null) {
                    i = C5419R.id.settings_text_images_compression_header;
                    TextView textView = (TextView) view.findViewById(C5419R.id.settings_text_images_compression_header);
                    if (textView != null) {
                        i = C5419R.id.settings_text_images_display_header;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.settings_text_images_display_header);
                        if (textView2 != null) {
                            i = C5419R.id.settings_text_images_embeds_toggle;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.settings_text_images_embeds_toggle);
                            if (checkedSetting3 != null) {
                                i = C5419R.id.settings_text_images_links_toggle;
                                CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(C5419R.id.settings_text_images_links_toggle);
                                if (checkedSetting4 != null) {
                                    i = C5419R.id.settings_text_images_preview_header;
                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.settings_text_images_preview_header);
                                    if (textView3 != null) {
                                        i = C5419R.id.settings_text_images_stickers_header;
                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.settings_text_images_stickers_header);
                                        if (textView4 != null) {
                                            i = C5419R.id.settings_text_images_sync_header;
                                            TextView textView5 = (TextView) view.findViewById(C5419R.id.settings_text_images_sync_header);
                                            if (textView5 != null) {
                                                i = C5419R.id.settings_text_images_sync_toggle;
                                                CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(C5419R.id.settings_text_images_sync_toggle);
                                                if (checkedSetting5 != null) {
                                                    i = C5419R.id.stickers_suggestions;
                                                    CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(C5419R.id.stickers_suggestions);
                                                    if (checkedSetting6 != null) {
                                                        return new WidgetSettingsMediaBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, linkifiedTextView, textView, textView2, checkedSetting3, checkedSetting4, textView3, textView4, textView5, checkedSetting5, checkedSetting6);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
