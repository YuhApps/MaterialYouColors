package dev.yuhapps.myc;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import static android.content.res.Configuration.*;
import static android.view.WindowInsetsController.*;
import static android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    public static final int WHITE = Color.WHITE;
    public static final int GREY_202020 = 0xFF202020;
    public static final int GREY_303030 = 0xFF303030;
    
    public static final List<Object> LIST_SOURCE = Arrays.asList(
            new Pair<>("Accent 1", android.R.color.system_accent1_400),
            new Pair<>(0, android.R.color.system_accent1_0),
            new Pair<>(10, android.R.color.system_accent1_10),
            new Pair<>(50, android.R.color.system_accent1_50),
            new Pair<>(100, android.R.color.system_accent1_100),
            new Pair<>(200, android.R.color.system_accent1_200),
            new Pair<>(300, android.R.color.system_accent1_300),
            new Pair<>(400, android.R.color.system_accent1_400),
            new Pair<>(500, android.R.color.system_accent1_500),
            new Pair<>(600, android.R.color.system_accent1_600),
            new Pair<>(700, android.R.color.system_accent1_700),
            new Pair<>(800, android.R.color.system_accent1_800),
            new Pair<>(900, android.R.color.system_accent1_900),
            new Pair<>("Accent 2", android.R.color.system_accent2_400),
            new Pair<>(0, android.R.color.system_accent2_0),
            new Pair<>(10, android.R.color.system_accent2_10),
            new Pair<>(50, android.R.color.system_accent2_50),
            new Pair<>(100, android.R.color.system_accent2_100),
            new Pair<>(200, android.R.color.system_accent2_200),
            new Pair<>(300, android.R.color.system_accent2_300),
            new Pair<>(400, android.R.color.system_accent2_400),
            new Pair<>(500, android.R.color.system_accent2_500),
            new Pair<>(600, android.R.color.system_accent2_600),
            new Pair<>(700, android.R.color.system_accent2_700),
            new Pair<>(800, android.R.color.system_accent2_800),
            new Pair<>(900, android.R.color.system_accent2_900),
            new Pair<>("Accent 3", android.R.color.system_accent3_400),
            new Pair<>(0, android.R.color.system_accent3_0),
            new Pair<>(10, android.R.color.system_accent3_10),
            new Pair<>(50, android.R.color.system_accent3_50),
            new Pair<>(100, android.R.color.system_accent3_100),
            new Pair<>(200, android.R.color.system_accent3_200),
            new Pair<>(300, android.R.color.system_accent3_300),
            new Pair<>(400, android.R.color.system_accent3_400),
            new Pair<>(500, android.R.color.system_accent3_500),
            new Pair<>(600, android.R.color.system_accent3_600),
            new Pair<>(700, android.R.color.system_accent3_700),
            new Pair<>(800, android.R.color.system_accent3_800),
            new Pair<>(900, android.R.color.system_accent3_900),
            new Pair<>("Neutral 1", android.R.color.system_neutral1_400),
            new Pair<>(0, android.R.color.system_neutral1_0),
            new Pair<>(10, android.R.color.system_neutral1_10),
            new Pair<>(50, android.R.color.system_neutral1_50),
            new Pair<>(100, android.R.color.system_neutral1_100),
            new Pair<>(200, android.R.color.system_neutral1_200),
            new Pair<>(300, android.R.color.system_neutral1_300),
            new Pair<>(400, android.R.color.system_neutral1_400),
            new Pair<>(500, android.R.color.system_neutral1_500),
            new Pair<>(600, android.R.color.system_neutral1_600),
            new Pair<>(700, android.R.color.system_neutral1_700),
            new Pair<>(800, android.R.color.system_neutral1_800),
            new Pair<>(900, android.R.color.system_neutral1_900),
            new Pair<>("Neutral 2", android.R.color.system_neutral2_400),
            new Pair<>(0, android.R.color.system_neutral2_0),
            new Pair<>(10, android.R.color.system_neutral2_10),
            new Pair<>(50, android.R.color.system_neutral2_50),
            new Pair<>(100, android.R.color.system_neutral2_100),
            new Pair<>(200, android.R.color.system_neutral2_200),
            new Pair<>(300, android.R.color.system_neutral2_300),
            new Pair<>(400, android.R.color.system_neutral2_400),
            new Pair<>(500, android.R.color.system_neutral2_500),
            new Pair<>(600, android.R.color.system_neutral2_600),
            new Pair<>(700, android.R.color.system_neutral2_700),
            new Pair<>(800, android.R.color.system_neutral2_800),
            new Pair<>(900, android.R.color.system_neutral2_900)
    );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int uiMode = getResources().getConfiguration().uiMode & UI_MODE_NIGHT_MASK;
        final boolean dark = uiMode == UI_MODE_NIGHT_YES;
        setContentView(createContentView(dark));

        final Window window = getWindow();
        final WindowInsetsController windowInsetsController = window.getInsetsController();
        if (dark) {
            window.setStatusBarColor(GREY_303030);
        } else {
            window.setStatusBarColor(WHITE);
            window.setNavigationBarColor(WHITE);
            window.setNavigationBarDividerColor(0xFFE0E0E0);
            windowInsetsController.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS);
            windowInsetsController.setSystemBarsAppearance(APPEARANCE_LIGHT_NAVIGATION_BARS, APPEARANCE_LIGHT_NAVIGATION_BARS);
        }
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

        final LinearLayout contentView = new LinearLayout(this);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        contentView.setOrientation(LinearLayout.VERTICAL);
        contentView.setBackgroundColor(dark ? GREY_202020 : WHITE);
        final LinearLayout.LayoutParams expandedLP = new LinearLayout.LayoutParams(-1, 0);
        expandedLP.weight = 1F;

        contentView.addView(createToolbar(dark, twentyDP, sixteenDP, montserrat_bold, system_accent1_500, system_accent2_200), new LinearLayout.LayoutParams(-1, -2));
        contentView.addView(createRecyclerView(dark, twentyDP, sixteenDP, system_accent1_500, system_accent2_500, system_accent3_500, system_neutral1_500, system_neutral2_500, montserrat_bold, lato), expandedLP);

        return contentView;
    }

    private View createToolbar(boolean dark, int twentyDP, int sixteenDP, Typeface montserrat_bold, int system_accent1_500, int system_accent2_200) {
        final LinearLayout toolbar = new LinearLayout(this);
        toolbar.setPadding(twentyDP, sixteenDP, twentyDP, sixteenDP);
        toolbar.setGravity(Gravity.CENTER_VERTICAL);
        toolbar.setElevation(sixteenDP / 4);
        toolbar.setBackgroundColor(dark ? GREY_303030 : WHITE);

        final TextView title = new TextView(this);
        title.setTypeface(montserrat_bold);
        title.setTextSize(28.0F);
        title.setTextColor(dark ? system_accent2_200 : system_accent1_500);
        title.setText("Material You Colors");

        final ImageView action = new ImageView(this);
        final Drawable infoIcon = getDrawable(R.drawable.ic_info).mutate();
        infoIcon.setTintList(title.getTextColors());
        action.setImageDrawable(infoIcon);
        action.setOnClickListener(this);

        final LinearLayout.LayoutParams titleLP = new LinearLayout.LayoutParams(0, -2);
        titleLP.weight = 1F;
        toolbar.addView(title, titleLP);
        toolbar.addView(action, new LinearLayout.LayoutParams(-2, -2));
        return toolbar;
    }

    private RecyclerView createRecyclerView(boolean dark, int twentyDP, int sixteenDP, int system_accent1_500, int system_accent2_500, int system_accent3_500, int system_neutral1_500, int system_neutral2_500, Typeface montserrat_bold, Typeface lato) {
        final RecyclerView recyclerView = new RecyclerView(this);
        final RecyclerView.Adapter adapter = new RecyclerView.Adapter() {

            @Override
            public int getItemViewType(int position) {
                final Pair pair = (Pair) LIST_SOURCE.get(position);
                return pair.first instanceof String ? 0 : 1;
            }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                final View itemView = new TextView(parent.getContext());
                itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return new RecyclerView.ViewHolder(itemView) {};
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                final int viewType = getItemViewType(position);
                final TextView textView = (TextView) holder.itemView;
                if (viewType == 0) {
                    final Pair<String, Integer> pair = (Pair) LIST_SOURCE.get(position);
                    textView.setPadding(twentyDP, twentyDP, twentyDP, sixteenDP / 2);
                    textView.setTypeface(montserrat_bold);
                    textView.setTextSize(16F);
                    textView.setTextColor(textView.getContext().getColor(pair.second));
                    textView.setText(pair.first);
                } else {
                    final Pair<Integer, Integer> pair = (Pair) LIST_SOURCE.get(position);
                    textView.setBackgroundColor(textView.getContext().getColor(pair.second));
                    textView.setGravity(Gravity.CENTER);
                    textView.setPadding(twentyDP, sixteenDP / 2, twentyDP, sixteenDP / 2);
                    textView.setTypeface(lato);
                    textView.setTextColor(pair.first < 400 ? Color.BLACK : Color.WHITE);
                    textView.setText(String.valueOf(pair.first));
                }
            }

            @Override
            public int getItemCount() {
                return LIST_SOURCE.size();
            }
        };
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                final Pair pair = (Pair) LIST_SOURCE.get(position);
                return pair.first instanceof String ? 3 : 1;
            }
        });
        recyclerView.setClipToPadding(false);
        recyclerView.setPadding(twentyDP, sixteenDP, twentyDP, sixteenDP);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return recyclerView;
    }

    @Override
    public void onClick(View v) {
        final String title = "MYC, version " + BuildConfig.VERSION_NAME + "(" + BuildConfig.VERSION_CODE + ")";
        final String message =
                "This app gives Android developers a quick preview of Material You Colors generated from device's wallpaper. " +
                "To get a color from your code, simply call context.getColor and pass the value from android package. For example, " +
                "context.getColor(android.R.color.system_accent1_500) in Java/Kotlin or @android:color/system_accent1_500 in XML." +
                "\n\nShade of the accent system color at 0% perceptual luminance (system_1000) is always black, therefore it won't be necessarily listed." +
                "\n\nRequires Google Pixel and Samsung Galaxy devices running Android 12 or higher, or any Android devices made by " +
                "other brands running Android 13 or higher." +
                "\n\nDeveloped by YUH APPS. For more info, please visit https://yuhapps.dev.";
        PopupDialog.show(this, title, message);
    }
}
