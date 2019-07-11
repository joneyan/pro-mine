package com.jone.pro.admin.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: yanjing
 * @Date: 2019/4/9 下午3:10
 * @Description:
 */
@Component
public interface ArticleSearchRepository extends ElasticsearchRepository<Pepole, Long> {
}
