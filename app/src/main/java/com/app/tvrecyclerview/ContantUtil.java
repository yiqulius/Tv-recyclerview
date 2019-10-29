package com.app.tvrecyclerview;


class ContantUtil {
    static String[] TEST_DATAS = new String[]{"A测试文字A测试文字A测试文字A测试文字A测试文字", "B测试文字", "C测试文字", "D测试文字", "E测试文字", "F测试文字", "G测试文字", "H测试文字", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
    private static int[] mImgIds = new int[]{R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8};


    static int getImgResourceId(int position) {
        int pos;
        if (position < mImgIds.length) {
            pos = position;
        } else {
            pos = position - mImgIds.length;
        }
        return mImgIds[pos];
    }
}
