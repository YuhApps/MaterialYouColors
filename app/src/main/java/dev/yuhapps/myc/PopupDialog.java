package dev.yuhapps.myc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static android.content.res.Configuration.UI_MODE_NIGHT_MASK;
import static android.content.res.Configuration.UI_MODE_NIGHT_YES;

public class PopupDialog extends Dialog {

    public static final int GREY_404040 = 0xFF404040;
    public static final int TITLE_ID = View.generateViewId();
    public static final int MESSAGE_ID = View.generateViewId();

    private String mTitle, mMessage;

    public static PopupDialog show(Context context, String title, String message) {
        final PopupDialog dialog = new PopupDialog(context);
        dialog.mTitle = title;
        dialog.mMessage = message;
        dialog.show();
        return dialog;
    }

    public PopupDialog(@NonNull Context context) {
        super(context);
    }

    public PopupDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected PopupDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int uiMode = getResources().getConfiguration().uiMode & UI_MODE_NIGHT_MASK;
        final boolean dark = uiMode == UI_MODE_NIGHT_YES;
        setContentView(createContentView(dark));
    }

    protected Resources getResources() {
        return getContext().getResources();
    }

    protected int getColor(@ColorRes int color) {
        return getContext().getColor(color);
    }

    private View createContentView(boolean dark) {
        final Resources resources = getResources();
        final float density = resources.getDisplayMetrics().density;
        final int sixteenDP = (int) (16 * density);
        final int twentyDP = (int) (20 * density);
        final int system_accent1_500 = getColor(android.R.color.system_accent1_500);
        final int system_accent2_500 = getColor(android.R.color.system_accent2_500);
        final int system_accent2_200 = getColor(android.R.color.system_accent2_200);
        final int system_accent3_500 = getColor(android.R.color.system_accent3_500);
        final int system_neutral1_500 = getColor(android.R.color.system_neutral1_500);
        final int system_neutral2_500 = getColor(android.R.color.system_neutral2_500);
        final Typeface montserrat_bold = resources.getFont(R.font.montserrat_bold);
        final Typeface lato = resources.getFont(R.font.lato);

        final LinearLayout contentView = new LinearLayout(getContext());
        contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        contentView.setBackground(createBackground(dark));
        contentView.setOrientation(LinearLayout.VERTICAL);
        contentView.setPadding(twentyDP, twentyDP, twentyDP, twentyDP);
        final LinearLayout.LayoutParams expandedLP = new LinearLayout.LayoutParams(-1, 0);
        expandedLP.weight = 1F;

        contentView.addView(createTitle(dark, twentyDP, sixteenDP, montserrat_bold, system_accent1_500, system_accent2_200), new LinearLayout.LayoutParams(-1, -2));
        contentView.addView(new View(getContext()), new LinearLayout.LayoutParams(-1, sixteenDP));
        contentView.addView(createMessage(dark, twentyDP, sixteenDP, montserrat_bold, lato, system_accent1_500, system_accent2_200), expandedLP);

        return contentView;
    }

    private GradientDrawable createBackground(boolean dark) {
        final int backgroundColor = dark ? GREY_404040 : Color.WHITE;
        final GradientDrawable background = new GradientDrawable();
        background.setCornerRadius(12);
        background.setColor(backgroundColor);
        return background;
    }

    private TextView createTitle(boolean dark, int twentyDP, int sixteenDP, Typeface montserrat_bold, int system_accent1_500, int system_accent2_200) {
        final TextView title = new TextView(getContext());
        title.setId(TITLE_ID);
        title.setTypeface(montserrat_bold);
        title.setTextSize(20.0F);
        title.setTextColor(dark ? system_accent2_200 : system_accent1_500);
        title.setText(mTitle);
        return title;
    }

    private TextView createMessage(boolean dark, int twentyDP, int sixteenDP, Typeface montserrat_bold, Typeface lato, int system_accent1_500, int system_accent2_200) {
        final TextView message = new TextView(getContext());
        message.setId(TITLE_ID);
        message.setJustificationMode(1);
        message.setTypeface(lato);
        message.setTextSize(16.0F);
        message.setTextColor(dark ? Color.WHITE : Color.BLACK);
        message.setText(mMessage);
        return message;
    }

    @Override
    public void show() {
        super.show();
        final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        final float density = displayMetrics.density;
        final float widthPixels = displayMetrics.widthPixels;
        final int width = (int) Math.min(360 * density, widthPixels * 0.9F);
        getWindow().setLayout(width, -2);
    }
}
