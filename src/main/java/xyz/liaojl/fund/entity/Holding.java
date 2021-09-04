package xyz.liaojl.fund.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.liaojl.fund.config.JpaLocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Holding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Column(name = "name")
    @Schema(hidden = true)
    private String name;

    @Column(name = "code")
    @Schema(example = "005669")
    @NotNull(message = "Please provide fund code!")
    @NotBlank(message = "Fund code can not be blank!")
    private String code;

    @Column(name = "share")
    @NotNull(message = "Please provide your share!")
    @Positive(message = "Your share must be greater than 0!")
    private double share;

    @Column(name = "create_time")
    @Schema(hidden = true)
    @Convert(converter = JpaLocalDateTimeConverter.class)
    private LocalDateTime createTime;

    @Schema(hidden = true)
    @Column(name = "update_time")
    @Convert(converter = JpaLocalDateTimeConverter.class)
    private LocalDateTime updateTime;
}
