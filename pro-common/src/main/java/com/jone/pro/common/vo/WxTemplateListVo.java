package com.jone.pro.common.vo;

import java.util.List;

/**
 * @Author: yanjing
 * @Date: 2018/11/29 下午5:21
 * @Description:
 */
public class WxTemplateListVo {
    private List<WxTemplateVo> template_list;
    public static class WxTemplateVo{
        private String template_id;
        private String title;
        private String primary_industry;
        private String deputy_industry;
        private String content;
        private String example;

        public String getTemplate_id() {
            return template_id;
        }

        public void setTemplate_id(String template_id) {
            this.template_id = template_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrimary_industry() {
            return primary_industry;
        }

        public void setPrimary_industry(String primary_industry) {
            this.primary_industry = primary_industry;
        }

        public String getDeputy_industry() {
            return deputy_industry;
        }

        public void setDeputy_industry(String deputy_industry) {
            this.deputy_industry = deputy_industry;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }
    }

    public List<WxTemplateVo> getTemplate_list() {
        return template_list;
    }

    public void setTemplate_list(List<WxTemplateVo> template_list) {
        this.template_list = template_list;
    }
}
