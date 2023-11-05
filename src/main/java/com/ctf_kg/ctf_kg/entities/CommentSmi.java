package com.ctf_kg.ctf_kg.entities;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentSmi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long userId;
    private String content;
    private String commentedDay;
    // Ensure this matches the FK column in the database
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id") // Ensure that 'product_id' is only referenced here.
//    private Product product;


}
